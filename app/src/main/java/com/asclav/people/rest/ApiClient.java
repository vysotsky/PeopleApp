package com.asclav.people.rest;

import com.asclav.people.rest.services.PeopleService;
import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by Vlad on 11/17/15.
 */
public class ApiClient {

	public static final String API_ROOT = "http://api.randomuser.me";

	private static volatile ApiClient instance;

	private PeopleService mPeopleService;

	private ApiClient() {
		init();
	}

	public static ApiClient getInstance() {
		ApiClient localInstance = instance;
		if (localInstance == null) {
			synchronized (ApiClient.class) {
				localInstance = instance;
				if (localInstance == null) {
					instance = localInstance = new ApiClient();
				}
			}
		}
		return localInstance;
	}

	public void init() {
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(API_ROOT)
				.addConverterFactory(GsonConverterFactory.create())
				.client(new OkHttpClient())
				.build();
		mPeopleService = retrofit.create(PeopleService.class);
	}

	public PeopleService getPeopleService() {
		return mPeopleService;
	}

}
