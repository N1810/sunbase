package com.neeraj.Sunbase.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.neeraj.Sunbase.Entity.Customer;
import com.neeraj.Sunbase.repository.Costumerrepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Costumerrepository customerRepository;

	public CustomerServiceImpl(Costumerrepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(id).get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(Long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

}
