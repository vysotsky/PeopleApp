package com.asclav.people.rest.services;

import com.asclav.people.rest.responses.RandomUserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Vlad on 11/17/15.
 */
public interface PeopleService {

	@GET("/") Call<RandomUserResponse> load(@Query("results") int count);

}
