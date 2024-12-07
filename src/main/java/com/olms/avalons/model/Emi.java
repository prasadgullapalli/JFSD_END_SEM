
package com.olms.avalons.model;

import static com.olms.avalons.utils.DateUtils.format;
import static com.olms.avalons.utils.DateUtils.getDisplayDate3;
import static com.olms.avalons.utils.DateUtils.toTimestamp;

import java.math.BigDecimal;
import java.util.Date;

public class Emi {

	private Long emiId;
	private Long period;
	private Date paymentDate;
	private BigDecimal payment;
	private BigDecimal currentBalance;
	private String status;

	private Long loanInfoId;
	private Long customerId;
	private boolean paymentOption;

	public Long getEmiId() {
		return emiId;
	}

	public void setEmiId(Long emiId) {
		this.emiId = emiId;
	}

	public Long getPeriod() {
		return period;
	}

	public void setPeriod(Long period) {
		this.period = period;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getLoanInfoId() {
		return loanInfoId;
	}

	public void setLoanInfoId(Long loanInfoId) {
		this.loanInfoId = loanInfoId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getEmiStatus() {

		if (this.status.equals("P")) {
			return "PENDING";
		}

		if (this.status.equals("C")) {
			return "COMPLETED";
		}

		return null;

	}

	public String getDisplayPaymentDate() {

		if (paymentDate == null) {
			return "";
		}

		return format(toTimestamp(paymentDate), getDisplayDate3());
	}

	public boolean isPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(boolean paymentOption) {
		this.paymentOption = paymentOption;
	}
}
