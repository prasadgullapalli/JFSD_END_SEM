
package com.olms.avalons.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.LoanInformationEntity;
import com.olms.avalons.model.LoanInformation;
import com.olms.avalons.repository.LoanInformationRepository;
import com.olms.avalons.service.LoanInformationService;


@Service
public class LoanInformationServiceImpl implements LoanInformationService {

	@Autowired
	private LoanInformationRepository loanInfoRepo;

	@Override
	public void saveLoanInfo(final LoanInformation loanInfo) {

		loanInfoRepo.saveloanInfo(loanInfo);
	}

	@Override
	public LoanInformation getLoanInformation(final Long infoId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanInformation getLoanInformationByRequestId(final Long requestId) {

		final LoanInformationEntity entity = loanInfoRepo.findloanInfoByRequestId(requestId);
		final LoanInformation info = new LoanInformation();
		copyProperties(entity, info);
		return info;
	}

	@Override
	public List<LoanInformation> getLoanInformationByCustomerId(final Long customerId) {

		final List<LoanInformationEntity> entities = loanInfoRepo.findAllloanInfos(customerId);

		return toServiceModel(entities);
	}

	List<LoanInformation> toServiceModel(final List<LoanInformationEntity> entities) {

		final List<LoanInformation> infos = new ArrayList<LoanInformation>();

		for (LoanInformationEntity entity : entities) {
			final LoanInformation information = new LoanInformation();
			copyProperties(entity, information);
			information.setCustomerId(entity.getCustomerEntity().getCustomerId());
			information.setLoanRequestId(entity.getLoanRequestEntity().getRequestId());
			information.setAmount(entity.getLoanRequestEntity().getAmount());
			information.setEmiMonths(entity.getLoanRequestEntity().getEmiMonths());
			information.setInterest(entity.getLoanRequestEntity().getOffersEntity().getInterest());
			information.setLoanName(entity.getLoanRequestEntity().getOffersEntity().getLoanName());
			infos.add(information);
		}

		return infos;
	}

	@Override
	public Long getLastInsertedId() {

		return loanInfoRepo.findLastInsertedId();
	}
}
