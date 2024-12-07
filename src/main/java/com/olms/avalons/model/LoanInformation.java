
package com.olms.avalons.model;

import static com.olms.avalons.utils.DateUtils.format;
import static com.olms.avalons.utils.DateUtils.getDisplayDate3;
import static com.olms.avalons.utils.DateUtils.toTimestamp;

import java.math.BigDecimal;
import java.util.Date;

public class LoanInformation {

	private Long infoId;
	private Date loanDate;
	private Date loanDueDate;
	private Long customerId;
	private Long loanRequestId;
	private BigDecimal amount;
	private Long emiMonths;
	private String loanName;
	private BigDecimal interest;
	private String status;

	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	public Date getLoanDueDate() {
		return loanDueDate;
	}

	public void setLoanDueDate(Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getLoanRequestId() {
		return loanRequestId;
	}

	public void setLoanRequestId(Long loanRequestId) {
		this.loanRequestId = loanRequestId;
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

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDisplayLoanDate() {

		if (loanDate == null) {
			return "-";
		}

		return format(toTimestamp(loanDate), getDisplayDate3());
	}

	public String getDisplayLoanDueDate() {

		if (loanDueDate == null) {
			return "-";
		}

		return format(toTimestamp(loanDueDate), getDisplayDate3());
	}
}
