package com.asclav.people.rest.services;

import com.asclav.people.rest.responses.RandomUserResponse;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Vlad on 11/17/15.
 */
public interface PeopleService {

	@GET("/") Call<RandomUserResponse> load(@Query("results") int count);

}
