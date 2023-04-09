package com.thesaintstech.springrestfulapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thesaintstech.springrestfulapi.data.CustomerRepository;
import com.thesaintstech.springrestfulapi.data.models.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository custRepo;
	
	@GetMapping("customer/{lastName}")
	public Iterable<Customer> getCustomersByLastName(@PathVariable String lastName){
		return custRepo.findByLastName(lastName);
	}
	
	@GetMapping("customer/{lastName}/{firstName}")
	public Customer getCustomerByFirstNameAndLastName(@PathVariable String firstName, @PathVariable String lastName) {
		return custRepo.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@PostMapping("customer")
	public void addCustomer(@RequestBody Customer customer) {
		custRepo.save(customer);
	}
	
	@DeleteMapping("customer/{id}")
	public void deleteCustomer(@PathVariable long id) {
		custRepo.deleteById(id);
	}
	
}
