
package com.olms.avalons.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.UserActivityEntity;
import com.olms.avalons.model.UserActivity;
import com.olms.avalons.repository.UserActivityRepository;
import com.olms.avalons.service.UserActivityService;
import com.olms.avalons.utils.DateUtils;

@Service
@Transactional
public class UserActivityServiceImpl implements UserActivityService {

	@Autowired
	private UserActivityRepository activityRepo;

	@Override
	public void saveUserActivity(final String activityType, final Long customerId) {

		final UserActivity activity = new UserActivity();
		activity.setActivityType(activityType);
		activity.setCustomerId(customerId);
		activity.setActivityTime(DateUtils.currentTimestamp());

		activityRepo.saveUserActivity(activity);
	}

	@Override
	public List<UserActivity> getActivitiesByCustomerId(final Long customerId) {

		return toServiceModel(activityRepo.findActivitiesByCustomerIdById(customerId));
	}

	List<UserActivity> toServiceModel(final List<UserActivityEntity> entities) {

		final List<UserActivity> activities = new ArrayList<UserActivity>();

		for (UserActivityEntity entity : entities) {

			final UserActivity activity = new UserActivity();
			copyProperties(entity, activity);
			activities.add(activity);
		}

		return activities;
	}
}
