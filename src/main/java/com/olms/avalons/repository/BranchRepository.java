package com.olms.avalons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.BranchEntity;

@Repository
public interface BranchRepository
		extends CrudRepository<BranchEntity, Long>, PagingAndSortingRepository<BranchEntity, Long> {

	@Query(value = "SELECT * FROM loan.branch", nativeQuery = true)
	List<BranchEntity> findAllBranches();
}
