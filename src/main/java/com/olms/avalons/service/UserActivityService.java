
package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.UserActivity;


public interface UserActivityService {

	void saveUserActivity(final String activityType, final Long customerId);

	List<UserActivity> getActivitiesByCustomerId(final Long customerId);
}
