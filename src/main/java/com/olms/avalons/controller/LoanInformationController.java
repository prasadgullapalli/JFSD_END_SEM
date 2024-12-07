/**
 * 
 */
package com.olms.avalons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.model.Customer;
import com.olms.avalons.model.Emi;
import com.olms.avalons.model.LoanInformation;
import com.olms.avalons.service.EmiService;
import com.olms.avalons.service.LoanInformationService;
import com.olms.avalons.utils.SessionUtils;

@Controller
@RequestMapping("loan-information")
public class LoanInformationController {

	@Autowired
	private LoanInformationService informationService;

	@Autowired
	private EmiService emiService;

	@GetMapping("loans")
	private ModelAndView getLoans(final HttpServletRequest request) {

		final ModelAndView modelAndView = new ModelAndView("loans-info");

		final Customer customer = SessionUtils.getCustomerInfo(request);

		final List<LoanInformation> infos = informationService.getLoanInformationByCustomerId(customer.getCustomerId());

		modelAndView.addObject("infos", infos);

		return modelAndView;
	}

	@PostMapping("emi")
	public ModelAndView getLoanInfo(final HttpServletRequest request, @RequestBody String infoId) {

		final Long loanInfoId = Long.valueOf(removeLastChars(infoId, 1));

		final ModelAndView modelAndView = new ModelAndView("loan-emi");

		final List<Emi> eims = emiService.getEmis(loanInfoId);

		modelAndView.addObject("eims", eims);

		return modelAndView;
	}

	public static String removeLastChars(String str, int chars) {
		return str.substring(0, str.length() - chars);
	}
}
