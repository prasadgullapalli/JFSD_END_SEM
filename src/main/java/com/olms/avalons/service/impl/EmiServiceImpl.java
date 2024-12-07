
package com.olms.avalons.service.impl;

import static com.olms.avalons.constants.Constants.COMPLETED;
import static com.olms.avalons.utils.DateUtils.currentTimestamp;
import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.EmiEntity;
import com.olms.avalons.model.Emi;
import com.olms.avalons.model.PaymentInformation;
import com.olms.avalons.repository.EmiRepository;
import com.olms.avalons.service.EmiService;
import com.olms.avalons.service.PaymentInformationService;


@Service
@Transactional
public class EmiServiceImpl implements EmiService {

	@Autowired
	private EmiRepository emiRepository;

	@Autowired
	private PaymentInformationService infoService;

	@Override
	public void saveEmi(final Emi emi) {

		emiRepository.saveEmi(emi);
	}

	@Override
	public List<Emi> getEmis(final Long loanInfoId) {

		return getEmis(emiRepository.findEmisByLoanInfoId(loanInfoId));
	}

	@Override
	public Emi getEmiById(final Long emiId) {

		final EmiEntity entity = emiRepository.findEmiById(emiId);
		final List<EmiEntity> entities = Arrays.asList(entity);

		return getEmis(entities).get(0);
	}

	@Override
	public void updatePayment(final PaymentInformation info) {

		emiRepository.updatePayment(info.getEmiId(), COMPLETED);

		final EmiEntity emi = emiRepository.findEmiById(info.getEmiId());

		info.setPaymentAmount(emi.getPayment());
		info.setPaymentDate(currentTimestamp());
		info.setStatus(COMPLETED);

		infoService.savePaymentInfo(info);
	}

	/**
	 * Converts entities to models.
	 * 
	 * @param entities entities.
	 * @return returns models.
	 */
	List<Emi> getEmis(final List<EmiEntity> entities) {

		final List<Emi> emis = new ArrayList<Emi>();

		for (EmiEntity entity : entities) {
			Emi emi = new Emi();
			copyProperties(entity, emi);
			emi.setLoanInfoId(entity.getLoanInfoEntity().getInfoId());
			emis.add(emi);
		}

		for (Emi emi : emis) {

			if (emi.getStatus().equals("P")) {
				emi.setPaymentOption(true);
				break;
			}
		}

		return emis;
	}
}
