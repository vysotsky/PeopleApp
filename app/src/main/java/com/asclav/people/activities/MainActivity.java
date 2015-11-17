package com.asclav.people.activities;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.asclav.people.R;
import com.asclav.people.fragments.MainActivityFragment;

import butterknife.Bind;

/**
 * Created by Vlad on 11/17/15.
 */
public class MainActivity extends BaseActivity {

	@Bind(R.id.toolbar) Toolbar mToolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setSupportActionBar(mToolbar);
		if (savedInstanceState == null) {
			getSupportFragmentManager()
					.beginTransaction()
					.add(R.id.container,
							MainActivityFragment.newInstance(),
							MainActivityFragment.class.getSimpleName())
					.commit();
		}
//		else {
//			getSupportFragmentManager()
//					.findFragmentByTag(MainActivityFragment.class.getSimpleName());
//		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
			case R.id.action_settings:
				return true;
			default:
				return super.onOptionsItemSelected(item);
		}
	}

}
