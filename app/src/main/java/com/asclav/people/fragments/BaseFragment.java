package com.asclav.people.fragments;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v4.app.Fragment;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Vlad on 11/17/15.
 */
public class BaseFragment extends Fragment {

	@CallSuper
	@Override public void onViewCreated(View view, Bundle savedInstanceState) {
		ButterKnife.bind(this, view);
	}

}
