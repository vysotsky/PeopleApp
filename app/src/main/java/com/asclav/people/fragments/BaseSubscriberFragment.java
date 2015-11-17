package com.asclav.people.fragments;

import com.asclav.people.bus.BusProvider;

/**
 * Created by Vlad on 11/17/15.
 */
public class BaseSubscriberFragment extends BaseFragment {

	@Override public void onStart() {
		super.onStart();
		BusProvider.bus().register(this);
	}

	@Override public void onStop() {
		super.onStop();
		BusProvider.bus().unregister(this);
	}

}
