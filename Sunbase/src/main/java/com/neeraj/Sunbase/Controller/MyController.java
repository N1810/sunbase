package com.neeraj.Sunbase.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.neeraj.Sunbase.Entity.Customer;
import com.neeraj.Sunbase.Service.CustomerService;

@Controller
public class MyController {

	private CustomerService customerservice;

	public MyController(CustomerService customerservice) {
		super();
		this.customerservice = customerservice;
	}

	// handler method to handle list Customer and return mode and view
	@GetMapping("/customers")
	public String listStudents(Model model) {
		model.addAttribute("customer", customerservice.getAllCustomers());
		return "customer";
	}

	@GetMapping("/customers/new")
	public String createCustomerForm(Model model) {

		// create Customer object to hold Customer form data
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "create_customer";

	}

	@PostMapping("/customers")
	public String saveCustomer(@ModelAttribute("student") Customer customer) {
		customerservice.saveCustomer(customer);
		return "redirect:/customer";
	}

	@GetMapping("/customers/edit/{id}")
	public String editCustomerForm(@PathVariable Long id, Model model) {
		model.addAttribute("customer", customerservice.getCustomerById(id));
		return "edit_customer";
	}

	@PostMapping("/customers/{id}")
	public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer, Model model) {

		// get Customer from database by id
		Customer existingCustomer = customerservice.getCustomerById(id);
		existingCustomer.setLastname(customer.getLastname());
		existingCustomer.setStreet(customer.getStreet());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setCity(customer.getCity());
		existingCustomer.setState(customer.getState());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());

		// save updated Customer object
		customerservice.updateCustomer(existingCustomer);
		return "redirect:/customers";
	}

	// handler method to handle delete Customer request

	@GetMapping("/customers/{id}")
	public String deleteCustomer(@PathVariable Long id) {
		customerservice.deleteCustomerById(id);
		return "redirect:/customers";
	}

}
