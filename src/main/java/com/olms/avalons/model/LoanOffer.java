package com.olms.avalons.model;

import java.math.BigDecimal;
import java.sql.Date;

import static com.olms.avalons.utils.DateUtils.*;

public class LoanOffer {

	private Long offerId;
	private String loanName;
	private BigDecimal loanRange;
	private Date startingDate;
	private Date endingDate;
	private String status;

	private Long loanTypeId;
	private String loanTypeName;
	private Long loanTenure;
	private BigDecimal interest;

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	public BigDecimal getLoanRange() {
		return loanRange;
	}

	public void setLoanRange(BigDecimal loanRange) {
		this.loanRange = loanRange;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Date endingDate) {
		this.endingDate = endingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getLoanTypeId() {
		return loanTypeId;
	}

	public void setLoanTypeId(Long loanTypeId) {
		this.loanTypeId = loanTypeId;
	}

	public String getLoanTypeName() {
		return loanTypeName;
	}

	public void setLoanTypeName(String loanTypeName) {
		this.loanTypeName = loanTypeName;
	}

	public Long getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(Long loanTenure) {
		this.loanTenure = loanTenure;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	public String getDisplayStartingDate() {

		return format(this.startingDate, getDisplayDate3());
	}

	public String getDisplayEndingDate() {

		return format(this.endingDate, getDisplayDate3());
	}

}
