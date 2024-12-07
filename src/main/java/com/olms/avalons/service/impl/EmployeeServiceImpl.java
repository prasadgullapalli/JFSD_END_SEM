package com.olms.avalons.service.impl;

import static org.springframework.beans.BeanUtils.copyProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.olms.avalons.entity.EmployeeEntity;
import com.olms.avalons.model.Employee;
import com.olms.avalons.repository.EmployeeRepository;
import com.olms.avalons.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee getByUserIdAndPasswordAndBranchId(final String emailId, final String password,
			final Long branchId) {

		final EmployeeEntity employeeEntity = employeeRepository.findByEmployeeEmailAndPasswordAndBranchId(emailId,
				password, branchId);

		if (employeeEntity == null) {
			return null;
		}

		final Employee employee = new Employee();
		copyProperties(employeeEntity, employee);
		employee.setBranchName(employeeEntity.getBranchEntity().getName());
		employee.setBranchCode(employeeEntity.getBranchEntity().getBranchCode());

		return employee;
	}

	@Override
	public Employee getById(final Long empId) {

		final EmployeeEntity entity = employeeRepository.findByEmployeeId(empId);

		if (entity == null) {
			return null;
		}

		final Employee employee = new Employee();
		copyProperties(entity, employee);
		employee.setBranchId(entity.getBranchEntity().getBranchId());

		return employee;
	}
}
