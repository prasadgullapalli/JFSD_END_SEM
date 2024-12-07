
package com.olms.avalons.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.LoanInformationEntity;
import com.olms.avalons.model.LoanInformation;

@Repository
@Transactional
public interface LoanInformationRepository extends JpaRepository<LoanInformationEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO loan_information ( loan_date, loan_due_date, customer_id, request_id) VALUES( :#{#loanInfo.loanDate}, :#{#loanInfo.loanDueDate}, :#{#loanInfo.customerId}, :#{#loanInfo.loanRequestId});", nativeQuery = true)
	void saveloanInfo(@Param("loanInfo") final LoanInformation loanInfo);

	@Query(value = "SELECT * FROM loan_information info WHERE info.customer_id = :customerId", nativeQuery = true)
	List<LoanInformationEntity> findAllloanInfos(@Param("customerId") final Long customerId);

	@Query(value = "SELECT * FROM loan_information info WHERE info.request_id = :requestId", nativeQuery = true)
	LoanInformationEntity findloanInfoByRequestId(@Param("requestId") final Long requestId);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();
	
	@Query(value = "SELECT lr.status, COUNT(*) FROM loan_request lr " +
	        "JOIN loan_information li ON lr.request_id = li.request_id " +
	        "GROUP BY lr.status", nativeQuery = true)
	List<Object[]> getLoanCountByStatus();

}
