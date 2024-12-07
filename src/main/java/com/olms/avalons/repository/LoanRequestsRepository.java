package com.olms.avalons.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.LoanRequestsEntity;
import com.olms.avalons.model.LoanRequest;

@Repository
@Transactional
public interface LoanRequestsRepository extends JpaRepository<LoanRequestsEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO loan_request ( emi_months, requested_date, purpose, status, customer_id, offer_id, amount, branch_id) VALUES( :#{#loanRequest.emiMonths}, :#{#loanRequest.loanRequestedDate}, :#{#loanRequest.purpose}, :#{#loanRequest.status}, :#{#loanRequest.customerId}, :#{#loanRequest.offerId}, :#{#loanRequest.amount}, :#{#loanRequest.branchId});", nativeQuery = true)
	void saveloanRequest(@Param("loanRequest") final LoanRequest loanRequest);

	@Query(value = "SELECT * FROM loan_request req WHERE req.branch_id = :branchId AND req.status = :status", nativeQuery = true)
	List<LoanRequestsEntity> findAllLoanRequests(@Param("branchId") final Long branchId,
			@Param("status") final String status);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE loan_request lr SET lr.status = :status WHERE lr.request_id = :requestId", nativeQuery = true)
	void processLoanRequest(@Param("requestId") final Long requestId, @Param("status") final String status);

	@Query(value = "SELECT * FROM loan_request req WHERE req.request_id = :requestId", nativeQuery = true)
	LoanRequestsEntity findLoanRequestById(@Param("requestId") final Long requestId);
	
	@Query(value = "SELECT * FROM loan_request req WHERE req.customer_id = :customerId", nativeQuery = true)
	List<LoanRequestsEntity> findLoanRequestByCustomerId(@Param("customerId") final Long customerId);
}