package com.olms.avalons.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.CustomerEntity;
import com.olms.avalons.model.Customer;
import com.olms.avalons.repository.CustomerRepository;
import com.olms.avalons.service.CustomerService;
import com.olms.avalons.utils.DateUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer getByUserNameAndPassword(final String userName, final String password) {

		final CustomerEntity customerEntity = customerRepository.findByCustomerNameAndPassword(userName, password);

		if (customerEntity == null) {
			return null;
		}

		final Customer customer = new Customer();
		copyProperties(customerEntity, customer);
		return customer;
	}

	@Override
	public Long saveCustomer(final Customer customer) {

		customerRepository.saveCustomer(customer);

		final Long customerId = customerRepository.findLastInsertedId();

		return customerId;
	}

	@Override
	public Customer getCustomerById(final Long customerId) {

		final CustomerEntity entity = customerRepository.findByCustomerById(customerId);
		final Customer customer = new Customer();
		copyProperties(entity, customer);
		customer.setDob(DateUtils.timestampToDate(entity.getDob()));

		return customer;
	}

	@Override
	public void updateCustomer(final Customer customer) {

		customerRepository.updateCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {

		final List<CustomerEntity> entities = customerRepository.findAllCustomers();

		return toServiceModel(entities);
	}

	List<Customer> toServiceModel(final List<CustomerEntity> entities) {

		final List<Customer> customers = new ArrayList<Customer>();

		for (CustomerEntity entity : entities) {
			Customer customer = new Customer();
			copyProperties(entity, customer);
			customers.add(customer);
		}

		return customers;
	}
}
