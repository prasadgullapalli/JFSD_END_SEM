package com.olms.avalons.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.LoanTypeEntity;

@Repository
@Transactional
public interface LoanTypeRepository extends JpaRepository<LoanTypeEntity, Long> {

	@Query(value = "SELECT * FROM loan_type;", nativeQuery = true)
	List<LoanTypeEntity> findAllLoanTypes();

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();
}
