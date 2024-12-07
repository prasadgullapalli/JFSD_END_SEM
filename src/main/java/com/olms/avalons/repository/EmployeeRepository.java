package com.olms.avalons.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository
		extends CrudRepository<EmployeeEntity, Long>, PagingAndSortingRepository<EmployeeEntity, Long> {

	@Query(value = "SELECT * FROM loan.employee a WHERE a.email_id = :emailId and a.password = :password and a.branch_id = :branchId", nativeQuery = true)
	EmployeeEntity findByEmployeeEmailAndPasswordAndBranchId(final String emailId, final String password, final Long branchId);

	@Query(value = "SELECT * FROM loan.employee a WHERE a.emp_id = :id", nativeQuery = true)
	EmployeeEntity findByEmployeeId(final Long id);
}
