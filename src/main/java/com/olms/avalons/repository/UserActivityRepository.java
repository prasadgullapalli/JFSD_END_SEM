package com.olms.avalons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.UserActivityEntity;
import com.olms.avalons.model.UserActivity;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivityEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO user_activity ( activity_type, activity_time, customer_id) VALUES( :#{#activity.activityType}, :#{#activity.activityTime}, :#{#activity.customerId});", nativeQuery = true)
	void saveUserActivity(@Param("activity") final UserActivity userActivity);

	@Query(value = "SELECT * FROM user_activity act WHERE act.customer_id = :customerId order by act.activity_time desc", nativeQuery = true)
	List<UserActivityEntity> findActivitiesByCustomerIdById(@Param("customerId") final Long customerId);
}
