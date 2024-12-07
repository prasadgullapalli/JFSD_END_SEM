
package com.olms.avalons.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.model.Customer;
import com.olms.avalons.model.UserActivity;
import com.olms.avalons.service.CustomerService;
import com.olms.avalons.service.UserActivityService;
import com.olms.avalons.utils.SessionUtils;

@Controller
@RequestMapping("user-activity")
public class UserActivityController {

	@Autowired
	private UserActivityService activityService;

	@Autowired
	private CustomerService customerService;

	@GetMapping("customers")
	public ModelAndView showUserActivities(final HttpServletRequest request) {

		final ModelAndView modelAndView = new ModelAndView("user-activity");

		final List<Customer> customers = customerService.getAllCustomers();
		modelAndView.addObject("customers", customers);

		return modelAndView;
	}

	@PostMapping("activities")
	@ResponseBody
	private ModelMap getUserActivity(final HttpServletRequest request, @RequestBody Long customerId) {

		final List<UserActivity> activities = activityService.getActivitiesByCustomerId(customerId);

		final ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("activities", activities);

		return modelMap;
	}

	@GetMapping("cust-activity")
	public ModelAndView showCustomerActivities(final HttpServletRequest request) {

		final ModelAndView modelAndView = new ModelAndView("user-activities");

		final Customer customer = SessionUtils.getCustomerInfo(request);

		final List<UserActivity> activities = activityService.getActivitiesByCustomerId(customer.getCustomerId());
		modelAndView.addObject("activities", activities);

		return modelAndView;
	}
}
