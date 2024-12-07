
package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.LoanInformation;

public interface LoanInformationService {

	void saveLoanInfo(final LoanInformation loanInfo);

	LoanInformation getLoanInformation(final Long infoId);
	
	LoanInformation getLoanInformationByRequestId(final Long requestId);

	List<LoanInformation> getLoanInformationByCustomerId(final Long customerId);

	Long getLastInsertedId();
}
