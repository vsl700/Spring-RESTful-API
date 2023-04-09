package com.thesaintstech.springrestfulapi.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thesaintstech.springrestfulapi.data.models.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	Customer findByFirstNameAndLastName(String firstName, String lastName);
	List<Customer> findByLastName(String lastName);
	
}
