
package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.Emi;
import com.olms.avalons.model.PaymentInformation;


public interface EmiService {

	void saveEmi(final Emi emi);

	List<Emi> getEmis(final Long loanInfoId);

	Emi getEmiById(final Long emiId);

	void updatePayment(final PaymentInformation info);
}
