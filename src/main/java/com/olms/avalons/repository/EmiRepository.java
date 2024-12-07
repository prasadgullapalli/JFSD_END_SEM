
package com.olms.avalons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.EmiEntity;
import com.olms.avalons.model.Emi;

@Repository
public interface EmiRepository extends JpaRepository<EmiEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO emi (period, payment_date, payment, current_balance, status, info_id, customer_id) values (:#{#emi.period}, :#{#emi.paymentDate}, :#{#emi.payment}, :#{#emi.currentBalance}, :#{#emi.status}, :#{#emi.loanInfoId},:#{#emi.customerId})", nativeQuery = true)
	void saveEmi(@Param("emi") final Emi emi);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();

	@Query(value = "SELECT * FROM emi em WHERE em.info_id = :infoId", nativeQuery = true)
	List<EmiEntity> findEmisByLoanInfoId(@Param("infoId") final Long infoId);

	@Query(value = "SELECT * FROM emi em WHERE em.emi_id = :emiId", nativeQuery = true)
	EmiEntity findEmiById(@Param("emiId") final Long emiId);
	
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE emi em SET em.status = :status WHERE em.emi_id = :emiId", nativeQuery = true)
	void updatePayment(@Param("emiId") final Long emiId, @Param("status") final String status);
}
