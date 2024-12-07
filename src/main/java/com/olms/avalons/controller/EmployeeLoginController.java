package com.olms.avalons.controller;

import static com.olms.avalons.utils.SessionUtils.EMPLOYEE_LOGIN;
import static com.olms.avalons.utils.SessionUtils.isEmployeeLoggedIn;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.olms.avalons.model.Employee;
import com.olms.avalons.model.Branch;
import com.olms.avalons.service.EmployeeService;
import com.olms.avalons.service.BranchService;


@Controller
@RequestMapping("employee-login")
public class EmployeeLoginController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private BranchService branchService;

	@GetMapping("display")
	public ModelAndView home(final HttpServletRequest request, @ModelAttribute("employeeLogin") Employee adminLogin,
			final BindingResult result) {

		if (isEmployeeLoggedIn(request)) {
			return new ModelAndView("redirect:/employee/display");
		}

		final ModelAndView modelAndView = new ModelAndView("employee-login");
		final List<Branch> branches = branchService.getAllBranches();
		modelAndView.addObject("branches", prepareBranches(branches));

		return modelAndView;
	}

	Map<Long, String> prepareBranches(final List<Branch> branches) {

		final Map<Long, String> branchess = new LinkedHashMap<Long, String>();
		for (Branch branch : branches) {
			final String branchInfo =  branch.getName()+ " - " + branch.getBranchCode();

			branchess.put(branch.getBranchId(), branchInfo);
		}

		return branchess;
	}

	@PostMapping("submit")
	public ModelAndView submit(final HttpServletRequest request, @ModelAttribute("employeeLogin") Employee employeeLogin,
			final BindingResult result) {

		final ModelAndView modelAndView = new ModelAndView("employee-login");
		final Employee employee = employeeService.getByUserIdAndPasswordAndBranchId(employeeLogin.getEmailId(), employeeLogin.getPassword(), employeeLogin.getBranchId());

		if (employee == null) {
			final List<Branch> branches = branchService.getAllBranches();
			modelAndView.addObject("branches", prepareBranches(branches));
			modelAndView.addObject("invalidAdminLogin", "Invalid credentials..");
			return modelAndView;
		}

		final HttpSession session = request.getSession();
		session.setAttribute(EMPLOYEE_LOGIN, employee);

		return new ModelAndView("redirect:/employee/display");
	}

	@GetMapping("logout")
	public ModelAndView logout(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			session.invalidate();
		}

		final ModelAndView modelAndView = new ModelAndView("redirect:/employee-login/display");

		return modelAndView;
	}
}
