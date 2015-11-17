package com.asclav.people.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Vlad on 11/17/15.
 */
public class UserEntity implements Parcelable {

	private String mUsername;
	private String mPictureUrl;

	public UserEntity() {
	}

	public UserEntity(String username, String pictureUrl) {
		mUsername = username;
		mPictureUrl = pictureUrl;
	}

	public String getUsername() {
		return mUsername;
	}

	public void setUsername(String username) {
		mUsername = username;
	}

	public String getPictureUrl() {
		return mPictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		mPictureUrl = pictureUrl;
	}

	@Override public int describeContents() {
		return 0;
	}

	@Override public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(this.mUsername);
		dest.writeString(this.mPictureUrl);
	}

	protected UserEntity(Parcel in) {
		this.mUsername = in.readString();
		this.mPictureUrl = in.readString();
	}

	public static final Parcelable.Creator<UserEntity> CREATOR = new Parcelable.Creator<UserEntity>() {
		public UserEntity createFromParcel(Parcel source) {
			return new UserEntity(source);
		}

		public UserEntity[] newArray(int size) {
			return new UserEntity[size];
		}
	};

}
