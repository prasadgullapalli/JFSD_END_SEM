
package com.olms.avalons.model;

import java.math.BigDecimal;

public class LoanType {

	private Long typeId;
	private String loanType;
	private Long loanTenure;
	private BigDecimal interest;

	public Long getTypeId() {
		return typeId;
	}

	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
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
}
