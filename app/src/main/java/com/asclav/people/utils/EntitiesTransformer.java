package com.asclav.people.utils;

import com.asclav.people.entities.UserEntity;
import com.asclav.people.rest.responses.RandomUserResponse;

/**
 * eKreative
 * Created by Vlad on 2/8/16.
 */
public class EntitiesTransformer {

	public static UserEntity userResponse2userEntity(RandomUserResponse.User user) {
		return new UserEntity(user.getUsername(), user.getPicture().getLarge());
	}

}
