package com.olms.avalons.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.model.LoanOffer;
import com.olms.avalons.model.LoanType;
import com.olms.avalons.service.LoanOffersService;
import com.olms.avalons.service.LoanTypeService;

@Controller
@RequestMapping("loan-offers")
public class LoanOffersController {

	@Autowired
	private LoanOffersService offerService;

	@Autowired
	private LoanTypeService loanTypeService;

	@GetMapping("display")
	public ModelAndView showLoanOffers(final HttpServletRequest request,
			@ModelAttribute("loanOffers") LoanOffer loanOffers) {

		final ModelAndView modelAndView = new ModelAndView("loan-offers-list");
		final List<LoanOffer> offers = offerService.getLoanOffers();

		modelAndView.addObject("offers", offers);

		return modelAndView;
	}

	@GetMapping("save")
	public ModelAndView save(final HttpServletRequest request, @ModelAttribute("loanOffers") LoanOffer loanOffers) {

		final ModelAndView modelAndView = new ModelAndView("loan-offers-reg");

		final List<LoanType> types = loanTypeService.getLoanTypes();
		modelAndView.addObject("loanTypes", prepareLoanTypes(types));
		return modelAndView;
	}

	Map<Long, String> prepareLoanTypes(final List<LoanType> loanTypes) {

		final Map<Long, String> types = new LinkedHashMap<Long, String>();
		for (LoanType type : loanTypes) {
			types.put(type.getTypeId(), type.getLoanType());
		}

		return types;
	}

	@PostMapping("get-loan-offer")
	@ResponseBody
	public ModelMap getLoan(final HttpServletRequest request, @RequestBody Long loanOfferId) {

		final LoanOffer loanOffer = offerService.findById(loanOfferId);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("loanOffer", loanOffer);
		return modelMap;
	}

	@PostMapping("delete-loan-offer")
	@ResponseBody
	public ModelMap DeleteLoan(final HttpServletRequest request, @RequestBody Long loanOfferId) {

		offerService.deleteById(loanOfferId);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("deleteMessage", "Loan Offer Deleted Successfully..");
		return modelMap;
	}

	@PostMapping("update-loan-offer")
	@ResponseBody
	public ModelMap updateLoanOffer(final HttpServletRequest request, @RequestBody LoanOffer loanOffers) {

		offerService.updateLoanOffers(loanOffers);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("updateMessage", "Loan Offer Updated Successfully..");
		return modelMap;
	}

	@PostMapping("submit")
	public ModelAndView submit(final HttpServletRequest request, @ModelAttribute("loanOffers") LoanOffer loanOffers) {

		final ModelAndView modelAndView = new ModelAndView("loan-offers-reg", "loanOffers", new LoanOffer());

		offerService.saveLoanOffer(loanOffers);
		final List<LoanType> types = loanTypeService.getLoanTypes();
		modelAndView.addObject("loanTypes", prepareLoanTypes(types));

		modelAndView.addObject("saveMessage", "Loan Offer Saved Successfully..");

		return modelAndView;
	}

}
