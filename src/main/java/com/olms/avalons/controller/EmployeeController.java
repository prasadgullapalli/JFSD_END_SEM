package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.isEmployeeLoggedIn;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("employee")
public class EmployeeController {

	@GetMapping("display")
	public ModelAndView home(final HttpServletRequest request, final HttpServletResponse response) {

		if (isEmployeeLoggedIn(request)) {
			return new ModelAndView("employee-dashboard");
		}

		return new ModelAndView("redirect:/employee-login/display");
	}
}
