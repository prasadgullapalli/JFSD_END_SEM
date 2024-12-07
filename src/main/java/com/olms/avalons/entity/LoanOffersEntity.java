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
@Table(name = "loan_offers")
public class LoanOffersEntity {

	private Long offerId;
	private String loanName;
	private BigDecimal loanRange;
	private Timestamp startingDate;
	private Timestamp endingDate;
	private String status;
	private BigDecimal interest;

	private LoanTypeEntity typeEntity;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offer_id")
	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	@Column(name = "loan_name")
	public String getLoanName() {
		return loanName;
	}

	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}

	@Column(name = "loan_range", precision = 9, scale = 2)
	public BigDecimal getLoanRange() {
		return loanRange;
	}

	public void setLoanRange(BigDecimal loanRange) {
		this.loanRange = loanRange;
	}

	@Column(name = "starting_date")
	public Timestamp getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Timestamp startingDate) {
		this.startingDate = startingDate;
	}

	@Column(name = "ending_date")
	public Timestamp getEndingDate() {
		return endingDate;
	}

	public void setEndingDate(Timestamp endingDate) {
		this.endingDate = endingDate;
	}

	@Column(name = "status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "interest", precision = 4, scale = 2)
	public BigDecimal getInterest() {
		return interest;
	}

	public void setInterest(BigDecimal interest) {
		this.interest = interest;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	public LoanTypeEntity getTypeEntity() {
		return typeEntity;
	}

	public void setTypeEntity(LoanTypeEntity typeEntity) {
		this.typeEntity = typeEntity;
	}
}