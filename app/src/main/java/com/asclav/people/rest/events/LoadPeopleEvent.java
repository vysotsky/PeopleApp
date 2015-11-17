package com.asclav.people.rest.events;

import com.asclav.people.rest.responses.RandomUserResponse;

/**
 * Created by Vlad on 11/17/15.
 */
public class LoadPeopleEvent extends BaseNetworkEvent {

	public static final OnLoadingError FAILED = new OnLoadingError(UNHANDLED_MSG, UNHANDLED_CODE);

	public static class OnLoaded extends OnDone<RandomUserResponse> {

		public OnLoaded(RandomUserResponse response) {
			super(response);
		}

	}

	public static class OnLoadingStart extends OnStart<Integer> {

		public OnLoadingStart(Integer request) {
			super(request);
		}

	}

	public static class OnLoadingError extends OnFailed {

		public OnLoadingError(String errorMessage, int code) {
			super(errorMessage, code);
		}

	}

}
