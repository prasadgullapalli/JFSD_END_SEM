
package com.olms.avalons.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "loan_request")
public class LoanRequestsEntity {

	private Long requestId;
	private BigDecimal amount;
	private Long emiMonths;
	private String purpose;
	private String status;
	private Timestamp loanRequestedDate;

	private CustomerEntity customerEntity;
	private LoanOffersEntity offersEntity;
	private BranchEntity branchEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "request_id")
	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

	@Column(name = "amount", precision = 9, scale = 2)
	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "emi_months")
	public Long getEmiMonths() {
		return emiMonths;
	}

	public void setEmiMonths(Long emiMonths) {
		this.emiMonths = emiMonths;
	}

	@Column(name = "purpose")
	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "requested_date")
	public Timestamp getLoanRequestedDate() {
		return loanRequestedDate;
	}

	public void setLoanRequestedDate(Timestamp loanRequestedDate) {
		this.loanRequestedDate = loanRequestedDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "offer_id")
	public LoanOffersEntity getOffersEntity() {
		return offersEntity;
	}

	public void setOffersEntity(LoanOffersEntity offersEntity) {
		this.offersEntity = offersEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	public BranchEntity getBranchEntity() {
		return branchEntity;
	}

	public void setBranchEntity(BranchEntity branchEntity) {
		this.branchEntity = branchEntity;
	}
}