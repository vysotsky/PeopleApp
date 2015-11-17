package com.asclav.people.rest;

import com.asclav.people.rest.events.LoadPeopleEvent;
import com.asclav.people.rest.responses.RandomUserResponse;
import com.squareup.okhttp.ResponseBody;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.io.IOException;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

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

					@Override public void onResponse(final Response<RandomUserResponse> response, Retrofit retrofit) {
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

					@Override public void onFailure(Throwable error) {
						if (error != null && error.getMessage() != null) {
							mBus.post(new LoadPeopleEvent.OnLoadingError(error.getMessage(), -1));
						} else {
							mBus.post(LoadPeopleEvent.FAILED);
						}
					}
				});
	}

}