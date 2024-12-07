
package com.olms.avalons.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.PaymentInformationEntity;
import com.olms.avalons.model.PaymentInformation;

@Repository
public interface PaymentInfoRepository extends JpaRepository<PaymentInformationEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO payment_info ( payment_amount, payment_date, payment_type, status, emi_id) VALUES( :#{#info.paymentAmount}, :#{#info.paymentDate}, :#{#info.paymentType}, :#{#info.status}, :#{#info.emiId});", nativeQuery = true)
	void savePaymentInfo(@Param("info") final PaymentInformation info);

}
