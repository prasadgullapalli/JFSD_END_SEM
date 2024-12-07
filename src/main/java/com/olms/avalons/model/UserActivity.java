
package com.olms.avalons.model;

import java.sql.Timestamp;

import com.olms.avalons.utils.DateUtils;

public class UserActivity {

	// Loan applied, password changed, login, logout, payment paid.
	private String activityType;
	private Timestamp activityTime;
	private Long customerId;

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public Timestamp getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(Timestamp activityTime) {
		this.activityTime = activityTime;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getDisplayActivityTime() {

		if (activityTime == null) {
			return "";
		}

		return DateUtils.format(activityTime, DateUtils.getDisplayDateTime());
	}
}
