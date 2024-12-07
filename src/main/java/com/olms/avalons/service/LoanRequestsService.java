package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanInformation;
import com.olms.avalons.model.LoanRequest;


public interface LoanRequestsService {

	void saveLoanRequest(final LoanRequest loanRequest);

	List<LoanRequest> getAllLoanRequests(final Long employeeId, final String status);

	List<LoanInformation> getAllLoanRequestsByCustomerId(final Long customerId);

	void processLoanRequest(final Long loanRequestId, final String status);
}
