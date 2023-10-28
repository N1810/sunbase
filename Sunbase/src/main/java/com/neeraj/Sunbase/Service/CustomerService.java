package com.neeraj.Sunbase.Service;

import java.util.List;

import com.neeraj.Sunbase.Entity.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();

	Customer saveCustomer(Customer customer);

	Customer getCustomerById(Long id);

	Customer updateCustomer(Customer customer);

	void deleteCustomerById(Long id);

}
