package com.olms.avalons.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.apache.commons.lang3.StringUtils;

import com.olms.avalons.constants.Constants;
import com.olms.avalons.utils.DateUtils;

public class LoanTransaction {

	private Long transactionId;
	private BigDecimal amount;
	private Long emiMonths;
	private String purpose;
	private String status;
	private Timestamp loanRequestedDate;

	private Long customerId;
	private Long loanOfferId;
	private String customerName;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Long getEmiMonths() {
		return emiMonths;
	}

	public void setEmiMonths(Long emiMonths) {
		this.emiMonths = emiMonths;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getLoanRequestedDate() {
		return loanRequestedDate;
	}

	public void setLoanRequestedDate(Timestamp loanRequestedDate) {
		this.loanRequestedDate = loanRequestedDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getLoanOfferId() {
		return loanOfferId;
	}

	public void setLoanOfferId(Long loanOfferId) {
		this.loanOfferId = loanOfferId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getLoanStatus() {

		if (StringUtils.equals(this.status, Constants.APPROVED)) {
			return "Approved";
		}

		if (StringUtils.equals(this.status, Constants.DECLINED)) {
			return "Declined";
		}

		if (StringUtils.equals(this.status, Constants.PROCESSING)) {
			return "Processing";
		}

		return "";
	}

	public String getDisplaySubmittedDate() {

		if (loanRequestedDate == null) {
			return "";
		}

		return DateUtils.format(loanRequestedDate, DateUtils.getDisplayDateTime());
	}
}
