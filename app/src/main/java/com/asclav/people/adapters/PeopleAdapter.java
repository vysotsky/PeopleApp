package com.asclav.people.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.asclav.people.R;
import com.asclav.people.entities.UserEntity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Vlad on 11/17/15.
 */
public class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.ViewHolder> {

	private List<UserEntity> mUserEntities;

	public PeopleAdapter(List<UserEntity> userEntities) {
		mUserEntities = userEntities;
	}

	public PeopleAdapter() {
		mUserEntities = new ArrayList<>();
	}

	public void setItems(List<UserEntity> userEntities) {
		mUserEntities.clear();
		mUserEntities.addAll(userEntities);
		notifyDataSetChanged();
	}

	@Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.people_list_item, null);
		return new ViewHolder(root);
	}

	@Override public void onBindViewHolder(ViewHolder holder, int position) {
		holder.setItem(mUserEntities.get(position));
	}

	@Override public int getItemCount() {
		return mUserEntities.size();
	}

	public List<UserEntity> getUserEntities() {
		return mUserEntities;
	}

	public class ViewHolder extends RecyclerView.ViewHolder {

		@Bind(R.id.user_name) TextView mUserName;
		@Bind(R.id.user_pic) ImageView mUserPic;

		public ViewHolder(View itemView) {
			super(itemView);
			ButterKnife.bind(this, itemView);
		}

		public void setItem(UserEntity userEntity) {
			mUserName.setText(userEntity.getUsername());
			Picasso.with(mUserPic.getContext()).load(userEntity.getPictureUrl()).into(mUserPic);
		}

	}

}

