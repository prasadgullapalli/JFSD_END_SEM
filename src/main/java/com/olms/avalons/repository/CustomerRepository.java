package com.olms.avalons.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.olms.avalons.entity.CustomerEntity;
import com.olms.avalons.model.Customer;

@Repository
@Transactional
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	@Query(value = "select * from loan.customer c where c.email_id = :customerEmailId and c.password  = :password", nativeQuery = true)
	CustomerEntity findByCustomerNameAndPassword(final String customerEmailId, final String password);

	@Modifying(clearAutomatically = true)
	@Query(value = "insert into loan.customer (address, dob, email_id, first_name, gender, last_name, contact_num, password, ssn_number,occupation) values (:#{#customer.address}, :#{#customer.dob}, :#{#customer.emailId}, :#{#customer.firstName}, :#{#customer.gender}, :#{#customer.lastName}, :#{#customer.mobileNumber}, :#{#customer.password}, :#{#customer.ssnNumber}, :#{#customer.occupation})", nativeQuery = true)
	void saveCustomer(@Param("customer") final Customer customer);

	@Query(value = "SELECT LAST_INSERT_ID()", nativeQuery = true)
	Long findLastInsertedId();

	@Query(value = "select * from loan.customer c where c.customer_id = :customerId", nativeQuery = true)
	CustomerEntity findByCustomerById(final Long customerId);

	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE loan.customer cus SET cus.address = :#{#customer.address}, cus.dob = :#{#customer.dob}, cus.email_id = :#{#customer.emailId}, cus.first_name = :#{#customer.firstName}, cus.gender =:#{#customer.gender}, cus.last_name = :#{#customer.lastName}, cus.contact_num = :#{#customer.mobileNumber}, cus.password = :#{#customer.password}, cus.ssn_number = :#{#customer.ssnNumber}, cus.occupation = :#{#customer.occupation} WHERE cus.customer_id = :#{#customer.customerId}", nativeQuery = true)
	void updateCustomer(@Param("customer") final Customer customer);

	@Query(value = "select * from loan.customer", nativeQuery = true)
	List<CustomerEntity> findAllCustomers();
}
