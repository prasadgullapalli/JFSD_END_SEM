package com.olms.avalons.service;

import java.util.List;

import com.olms.avalons.model.Customer;

public interface CustomerService {

	Customer getByUserNameAndPassword(final String userName, final String password);

	Long saveCustomer(final Customer customre);

	Customer getCustomerById(final Long customerId);

	void updateCustomer(final Customer customer);

	List<Customer> getAllCustomers();
}
