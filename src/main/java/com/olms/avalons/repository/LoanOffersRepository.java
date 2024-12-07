package com.olms.avalons.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.LoanOffersEntity;
import com.olms.avalons.model.LoanOffer;

@Repository
@Transactional
public interface LoanOffersRepository extends JpaRepository<LoanOffersEntity, Long> {

	@Modifying(clearAutomatically = true)
	@Query(value = "INSERT INTO loan_offers (loan_name, loan_range, starting_date, ending_date, status, type_id, interest) values (:#{#loanOffer.loanName}, :#{#loanOffer.loanRange}, :#{#loanOffer.startingDate}, :#{#loanOffer.endingDate}, 'A', :#{#loanOffer.loanTypeId},:#{#loanOffer.interest})", nativeQuery = true)
	void saveloanOffer(@Param("loanOffer") final LoanOffer loanOffer);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();

	@Query(value = "SELECT * FROM loan_offers;", nativeQuery = true)
	List<LoanOffersEntity> findAllLoanOffers();

	@Query(value = "SELECT * FROM loan_offers lo WHERE lo.offer_id = :id", nativeQuery = true)
	LoanOffersEntity findByLoanId(final Long id);

	@Modifying
	@Query(value = "DELETE FROM loan.loan_offers lo WHERE lo.offer_id = :id", nativeQuery = true)
	void deleteById(final Long id);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE loan_offers lo SET lo.loan_range = :#{#loanOffer.loanRange}, lo.interest = :#{#loanOffer.interest}, lo.loan_name = :#{#loanOffer.loanName}, lo.starting_date = :#{#loanOffer.startingDate},lo.ending_date = :#{#loanOffer.endingDate} WHERE lo.offer_id = :#{#loanOffer.offerId}", nativeQuery = true)
	void updateLoanOffer(@Param("loanOffer") final LoanOffer loanOffer);
}
