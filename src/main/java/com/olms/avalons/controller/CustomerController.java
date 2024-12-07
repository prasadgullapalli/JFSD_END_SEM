package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.isCustomerLoggedIn;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.command.CustomerCommand;
import com.olms.avalons.model.Customer;
import com.olms.avalons.service.CustomerService;
import com.olms.avalons.utils.SessionUtils;


@Controller
@RequestMapping("customer-dashboard")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("display")
	public ModelAndView afterLogin(final HttpServletRequest request,
			@ModelAttribute("customerLogin") CustomerCommand customerLogin, final BindingResult result) {

		if (isCustomerLoggedIn(request)) {
			return new ModelAndView("customer-dashboard");
		}

		return new ModelAndView("redirect:/customer/display");
	}

	@GetMapping("profile")
	public ModelAndView customerProfile(final HttpServletRequest request,
			@ModelAttribute("customer") Customer customerUpdate) {

		final Customer customer = SessionUtils.getCustomerInfo(request);
		final Customer cust = customerService.getCustomerById(customer.getCustomerId());

		final ModelAndView modelAndView = new ModelAndView("customer-profile");
		modelAndView.addObject("customer", cust);

		return modelAndView;
	}

	@PostMapping("update")
	public ModelAndView updateCustomerProfile(final HttpServletRequest request,
			@ModelAttribute("customer") Customer customerUpdate) {

		final Customer customer = SessionUtils.getCustomerInfo(request);

		final ModelAndView modelAndView = new ModelAndView("customer-profile");
		modelAndView.addObject("customer", customerUpdate);

		customerUpdate.setCustomerId(customer.getCustomerId());
		customerService.updateCustomer(customerUpdate);
		modelAndView.addObject("message", "Customer Details Updated Successfully..");

		return modelAndView;
	}
}
