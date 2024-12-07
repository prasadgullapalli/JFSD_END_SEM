package com.olms.avalons.entity;

import java.math.BigDecimal;
import java.util.Date;

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
@Table(name = "emi")
public class EmiEntity {

	private Long emiId;
	private Long period;
	private Date paymentDate;
	private BigDecimal payment;
	private BigDecimal currentBalance;
	private String status;

	private LoanInformationEntity loanInfoEntity;
	private CustomerEntity customerEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emi_id")
	public Long getEmiId() {
		return emiId;
	}

	public void setEmiId(Long emiId) {
		this.emiId = emiId;
	}

	@Column(name = "period")
	public Long getPeriod() {
		return period;
	}

	public void setPeriod(Long period) {
		this.period = period;
	}

	@Column(name = "payment_date")
	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Column(name = "payment", precision = 9, scale = 2)
	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	@Column(name = "current_balance", precision = 9, scale = 2)
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigDecimal currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "info_id")
	public LoanInformationEntity getLoanInfoEntity() {
		return loanInfoEntity;
	}

	public void setLoanInfoEntity(LoanInformationEntity loanInfoEntity) {
		this.loanInfoEntity = loanInfoEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
}