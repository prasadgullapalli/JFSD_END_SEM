
package com.olms.avalons.service.impl;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.LoanTypeEntity;
import com.olms.avalons.model.LoanType;
import com.olms.avalons.repository.LoanTypeRepository;
import com.olms.avalons.service.LoanTypeService;


@Service
public class LoanTypeServiceImpl implements LoanTypeService {

	@Autowired
	private LoanTypeRepository repository;

	@Override
	public List<LoanType> getLoanTypes() {

		final List<LoanTypeEntity> entities = repository.findAllLoanTypes();

		if (isEmpty(entities)) {
			return new ArrayList<LoanType>();
		}

		return toServiceModel(entities);
	}

	final List<LoanType> toServiceModel(final List<LoanTypeEntity> entities) {

		final List<LoanType> types = new ArrayList<LoanType>();
		for (LoanTypeEntity entity : entities) {
			final LoanType type = new LoanType();
			copyProperties(entity, type);
			types.add(type);
		}

		return types;
	}
}
