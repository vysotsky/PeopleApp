package com.asclav.people.rest.responses;

import com.asclav.people.Normalizable;
import com.asclav.people.entities.UserEntity;

import java.util.List;

/**
 * Created by Vlad on 11/17/15.
 */
public class RandomUserResponse {

	List<UserWrapper> results;

	public RandomUserResponse(List<UserWrapper> results) {
		this.results = results;
	}

	public RandomUserResponse() {
	}

	public List<UserWrapper> getResults() {
		return results;
	}

	public void setResults(List<UserWrapper> results) {
		this.results = results;
	}

	public static class UserWrapper {

		User user;

		public UserWrapper() {
		}

		public UserWrapper(User user) {
			this.user = user;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

	}

	public static class User implements Normalizable<UserEntity> {
		String username;
		Picture picture;

		public User(String username, Picture picture) {
			this.username = username;
			this.picture = picture;
		}

		public User() {
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public Picture getPicture() {
			return picture;
		}

		public void setPicture(Picture picture) {
			this.picture = picture;
		}

		@Override public UserEntity normalize() {
			return new UserEntity(username, picture.large);
		}

		public static class Picture {

			String large;
			String medium;
			String thumbnail;

			public Picture(String large, String medium, String thumbnail) {
				this.large = large;
				this.medium = medium;
				this.thumbnail = thumbnail;
			}

			public Picture() {
			}

			public String getLarge() {
				return large;
			}

			public String getMedium() {
				return medium;
			}

			public String getThumbnail() {
				return thumbnail;
			}

		}

	}

}
