package com.olms.avalons.service.impl;

import static org.apache.commons.collections.CollectionUtils.isEmpty;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.LoanOffersEntity;
import com.olms.avalons.model.LoanOffer;
import com.olms.avalons.repository.LoanOffersRepository;
import com.olms.avalons.service.LoanOffersService;
import com.olms.avalons.utils.DateUtils;

@Service
public class LoanOffersServiceImpl implements LoanOffersService {

	@Autowired
	private LoanOffersRepository repository;

	@Override
	public void saveLoanOffer(final LoanOffer offer) {

		repository.saveloanOffer(offer);

		// TO-DO
		// % giving expection when we give 11.2 % like this, if we give 2.2 it is
		// working fine

		final Long loanOfferId = repository.findLastInsertedId();
	}

	@Override
	public List<LoanOffer> getLoanOffers() {

		final List<LoanOffersEntity> entities = repository.findAllLoanOffers();

		if (isEmpty(entities)) {
			return new ArrayList<LoanOffer>();
		}

		return toServiceModel(entities);
	}

	final List<LoanOffer> toServiceModel(final List<LoanOffersEntity> entities) {

		final List<LoanOffer> offers = new ArrayList<LoanOffer>();
		for (LoanOffersEntity entity : entities) {
			final LoanOffer offer = new LoanOffer();
			copyProperties(entity, offer);
			offer.setStartingDate(DateUtils.timestampToDate(entity.getStartingDate()));
			offer.setEndingDate(DateUtils.timestampToDate(entity.getEndingDate()));
			offer.setLoanTypeId(entity.getTypeEntity().getTypeId());
			offer.setLoanTypeName(entity.getTypeEntity().getLoanType());
			offer.setLoanTenure(entity.getTypeEntity().getLoanTenure());
			offers.add(offer);
		}

		return offers;
	}

	@Override
	public void updateLoanOffers(final LoanOffer offer) {

		repository.updateLoanOffer(offer);

	}

	@Override
	public LoanOffer findById(final Long loanOfferId) {

		final LoanOffersEntity entity = repository.findByLoanId(loanOfferId);
		final LoanOffer offer = new LoanOffer();
		copyProperties(entity, offer);
		offer.setStartingDate(DateUtils.timestampToDate(entity.getStartingDate()));
		offer.setEndingDate(DateUtils.timestampToDate(entity.getEndingDate()));
		offer.setLoanTypeId(entity.getTypeEntity().getTypeId());
		offer.setLoanTypeName(entity.getTypeEntity().getLoanType());
		offer.setLoanTenure(entity.getTypeEntity().getLoanTenure());

		return offer;
	}

	@Override
	public void deleteById(final Long id) {

		repository.deleteById(id);

	}
}
