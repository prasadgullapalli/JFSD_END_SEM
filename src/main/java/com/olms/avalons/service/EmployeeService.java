package com.olms.avalons.service;

import com.olms.avalons.model.Employee;
public interface EmployeeService {

	public Employee getByUserIdAndPasswordAndBranchId(final String emailId, final String password, final Long branchId);

	public Employee getById(final Long empId);
}
