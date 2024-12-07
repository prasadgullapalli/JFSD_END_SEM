package com.olms.avalons.utils;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.olms.avalons.model.Customer;
import com.olms.avalons.model.Employee;

public class SessionUtils {

	public static final String EMPLOYEE_LOGIN = "EMPLOYEE_LOGIN";
	public static final String CUSTOMER_LOGIN = "CUSTOMER_LOGIN";

	/**
	 * Finds out if the employee login is expired or not.
	 *
	 * @param request http request.
	 * @return true if the employee is logged in and session is active, false
	 *         otherwise.
	 */
	public static boolean isEmployeeLoggedIn(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			final Enumeration names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				final String name = (String) names.nextElement();
				if (StringUtils.equals(name, EMPLOYEE_LOGIN)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean isCustomerLoggedIn(final HttpServletRequest request) {

		final HttpSession session = request.getSession();
		if (session != null) {
			final Enumeration names = session.getAttributeNames();
			while (names.hasMoreElements()) {
				final String name = (String) names.nextElement();
				if (StringUtils.equals(name, CUSTOMER_LOGIN)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Returns the office information from the http session.
	 *
	 * @param request http request.
	 * @return office info.
	 */
	public static Customer getCustomerInfo(final HttpServletRequest request) {

		final HttpSession session = request.getSession();

		final Object attribute = session.getAttribute(CUSTOMER_LOGIN);
		if (attribute == null) {
			throw new IllegalStateException("Customer shouldn't be null");
		}

		final Customer customer = (Customer) attribute;
		if (customer.getCustomerId() == null) {
			throw new IllegalStateException("Customer id shouldn't be null");
		}

		return customer;
	}
	
	
	/**
	 * Returns the Employee information from the http session.
	 *
	 * @param request http request.
	 * @return employee info.
	 */
	public static Employee getEmployeeInfo(final HttpServletRequest request) {

		final HttpSession session = request.getSession();

		final Object attribute = session.getAttribute(EMPLOYEE_LOGIN);
		if (attribute == null) {
			throw new IllegalStateException("Employee shouldn't be null");
		}

		final Employee employee = (Employee) attribute;
		if (employee.getEmpId() == null) {
			throw new IllegalStateException("Employee id shouldn't be null");
		}

		return employee;
	}
}
