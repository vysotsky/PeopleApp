package com.asclav.people.fragments;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.asclav.people.R;
import com.asclav.people.adapters.PeopleAdapter;
import com.asclav.people.bus.BusProvider;
import com.asclav.people.entities.UserEntity;
import com.asclav.people.rest.events.LoadPeopleEvent;
import com.asclav.people.utils.EntitiesTransformer;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.OnClick;

/**
 * Created by Vlad on 11/17/15.
 */
public class MainFragment extends BaseSubscriberFragment {

	public static final int COUNT = 20;
	public static final String LIST = "list";

	@Bind(R.id.recycler) RecyclerView mRecyclerView;
	private PeopleAdapter mAdapter;

	public static MainFragment newInstance() {
		return new MainFragment();
	}

	public MainFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_main, container, false);
	}

	@Override public void onSaveInstanceState(Bundle outState) {
		outState.putParcelableArrayList(LIST, (ArrayList<? extends Parcelable>) mAdapter.getUserEntities());
	}

	@Override public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		LinearLayoutManager layout = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(layout);
		if (savedInstanceState != null) {
			mAdapter = new PeopleAdapter(savedInstanceState.getParcelableArrayList(LIST));
		} else {
			mAdapter = new PeopleAdapter();
		}
		mRecyclerView.setAdapter(mAdapter);
	}

	@OnClick(R.id.load_btn) public void onButtonClicked() {
		Toast.makeText(getContext(), "Let's start!", Toast.LENGTH_LONG).show();
		BusProvider.bus().post(new LoadPeopleEvent.OnLoadingStart(COUNT));
	}

	@Subscribe public void onUsersLoaded(LoadPeopleEvent.OnLoaded onLoaded) {
		Toast.makeText(getContext(), "Loaded " + onLoaded.getResponse().getResults().size() + " items", Toast.LENGTH_LONG).show();
		List<UserEntity> entityList = Stream.of(onLoaded.getResponse().getResults())
				.map(value -> EntitiesTransformer.userResponse2userEntity(value.getUser()))
				.collect(Collectors.toList());
		mAdapter.setItems(entityList);
	}

	@Subscribe public void onUsersLoadingFailed(LoadPeopleEvent.OnLoadingError onLoadingError) {
		Toast.makeText(getContext(), onLoadingError.getErrorMessage(), Toast.LENGTH_LONG).show();
	}

}
