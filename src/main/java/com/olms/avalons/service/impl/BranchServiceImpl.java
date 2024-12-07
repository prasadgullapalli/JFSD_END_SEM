
package com.olms.avalons.service.impl;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.BranchEntity;
import com.olms.avalons.model.Branch;
import com.olms.avalons.repository.BranchRepository;
import com.olms.avalons.service.BranchService;

@Service
public class BranchServiceImpl implements BranchService {

	@Autowired
	private BranchRepository branchRepo;

	@Override
	public List<Branch> getAllBranches() {

		final List<BranchEntity> entities = branchRepo.findAllBranches();

		if (isEmpty(entities)) {
			return new ArrayList<Branch>();
		}

		return toServiceModel(entities);
	}

	final List<Branch> toServiceModel(final List<BranchEntity> entities) {

		final List<Branch> branches = new ArrayList<Branch>();
		for (BranchEntity entity : entities) {
			final Branch branch = new Branch();
			copyProperties(entity, branch);
			branches.add(branch);
		}

		return branches;
	}
}
