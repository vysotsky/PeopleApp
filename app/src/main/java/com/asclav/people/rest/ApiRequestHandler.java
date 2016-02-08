package com.asclav.people.rest;

import com.asclav.people.rest.events.LoadPeopleEvent;
import com.asclav.people.rest.responses.RandomUserResponse;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vlad on 11/17/15.
 */
public class ApiRequestHandler {

	private Bus mBus;
	private ApiClient mApiClient;

	public ApiRequestHandler(Bus bus) {
		mBus = bus;
		mApiClient = ApiClient.getInstance();
	}

	@Subscribe public void onLoadingStart(LoadPeopleEvent.OnLoadingStart onLoadingStart) {
		mApiClient.getPeopleService().load(onLoadingStart.getRequest())
				.enqueue(new Callback<RandomUserResponse>() {

					@Override public void onResponse(Call<RandomUserResponse> call, Response<RandomUserResponse> response) {
						if (response.isSuccess()) {
							mBus.post(new LoadPeopleEvent.OnLoaded(response.body()));
						} else {
							int statusCode = response.code();
							ResponseBody errorBody = response.errorBody();
							try {
								mBus.post(new LoadPeopleEvent.OnLoadingError(errorBody.string(), statusCode));
							} catch (IOException e) {
								mBus.post(LoadPeopleEvent.FAILED);
							}
						}
					}

					@Override public void onFailure(Call<RandomUserResponse> call, Throwable error) {
						if (error != null && error.getMessage() != null) {
							mBus.post(new LoadPeopleEvent.OnLoadingError(error.getMessage(), -1));
						} else {
							mBus.post(LoadPeopleEvent.FAILED);
						}
					}
				});
	}

}