package com.asclav.people;

import android.app.Application;

import com.asclav.people.bus.BusProvider;
import com.asclav.people.rest.ApiRequestHandler;
import com.squareup.otto.Bus;

/**
 * Created by Vlad on 11/17/15.
 */
public class PeopleApp extends Application {

	public static ApiRequestHandler mApiRequestHandler;
	private Bus mBus = BusProvider.bus();

	@Override public void onCreate() {
		super.onCreate();
		mApiRequestHandler = new ApiRequestHandler(mBus);
		mBus.register(mApiRequestHandler);
	}

}
