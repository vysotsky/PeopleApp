package com.asclav.people.rest.events;

/**
 * Created by Vlad on 11/17/15.
 */
public class BaseNetworkEvent {

	public static final String UNHANDLED_MSG = "UNHANDLED_MSG";
	public static final int UNHANDLED_CODE = -1;

	protected static class OnStart<Rq> {
		private Rq mRequest;

		public OnStart(Rq request) {
			mRequest = request;
		}

		public Rq getRequest() {
			return mRequest;
		}
	}

	protected static class OnDone<Rs> {

		private Rs mResponse;

		public OnDone(Rs response) {
			mResponse = response;
		}

		public Rs getResponse() {
			return mResponse;
		}

	}

	protected static class OnFailed {

		private String mErrorMessage;
		private int mCode;

		public OnFailed(String errorMessage, int code) {
			mErrorMessage = errorMessage;
			mCode = code;
		}

		public String getErrorMessage() {
			return mErrorMessage;
		}

		public int getCode() {
			return mCode;
		}

	}

}