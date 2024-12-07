/**
 * 
 */
package com.olms.avalons.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.olms.avalons.constants.Constants;
import com.olms.avalons.model.Customer;
import com.olms.avalons.model.Emi;
import com.olms.avalons.model.PaymentInformation;
import com.olms.avalons.service.EmiService;
import com.olms.avalons.service.UserActivityService;
import com.olms.avalons.utils.SessionUtils;


@Controller
@RequestMapping("emi")
public class EmiController {

	@Autowired
	private EmiService emiService;

	@Autowired
	private UserActivityService activityService;

	@PostMapping("info")
	@ResponseBody
	public ModelMap getEmiInfo(final HttpServletRequest request, @RequestBody Long emiId) {

		final ModelMap map = new ModelMap();
		final Emi emi = emiService.getEmiById(emiId);
		map.addAttribute("emi", emi);

		return map;
	}

	@PostMapping("pay")
	@ResponseBody
	public ModelMap getEmiInfo(final HttpServletRequest request, @RequestBody PaymentInformation payInfo) {

		final ModelMap map = new ModelMap();

		emiService.updatePayment(payInfo);
		map.addAttribute("message", "Payment done successfully..");

		final Customer customer = SessionUtils.getCustomerInfo(request);

		activityService.saveUserActivity(Constants.PAID, customer.getCustomerId());

		System.out.println(payInfo.getEmiId());
		return map;
	}
}
