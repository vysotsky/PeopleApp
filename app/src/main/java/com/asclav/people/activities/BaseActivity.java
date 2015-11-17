package com.asclav.people.activities;

import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by Vlad on 11/17/15.
 */
public class BaseActivity extends AppCompatActivity {

	@Override public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.bind(this);
	}

}
