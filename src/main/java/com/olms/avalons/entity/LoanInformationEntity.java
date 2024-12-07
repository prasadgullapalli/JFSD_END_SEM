package com.olms.avalons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "loan_information")
public class LoanInformationEntity {

	private Long infoId;
	// Loan approved date.
	private Date loanDate;
	// loan due date.
	private Date loanDueDate;

	// Many to one
	// Many loans info's to one customer or One customer can have many loans.
	private CustomerEntity customerEntity;

	// One to one
	// One loan info to one loan request or one loan request can have one
	// loan info.
	private LoanRequestsEntity loanRequestEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "info_id")
	public Long getInfoId() {
		return infoId;
	}

	public void setInfoId(Long infoId) {
		this.infoId = infoId;
	}

	@Column(name = "loan_date")
	public Date getLoanDate() {
		return loanDate;
	}

	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}

	@Column(name = "loan_due_date")
	public Date getLoanDueDate() {
		return loanDueDate;
	}

	public void setLoanDueDate(Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "request_id")
	public LoanRequestsEntity getLoanRequestEntity() {
		return loanRequestEntity;
	}

	public void setLoanRequestEntity(LoanRequestsEntity loanRequestEntity) {
		this.loanRequestEntity = loanRequestEntity;
	}
}