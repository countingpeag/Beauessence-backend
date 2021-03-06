package com.beauessence.agenda.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauessence.agenda.models.Customer;
import com.beauessence.agenda.services.CustomerServices;

@RestController
@RequestMapping("customer")
public class CustomerController {

	private CustomerServices customerServices;
	
	@Autowired
	public CustomerController(CustomerServices customerServices) {
		this.customerServices=customerServices;
	}
	
	@GetMapping(value = {"getCustomers", "getCustomer/{id}"})
	public ResponseEntity<List<Customer>> retrieveCustomers(@PathVariable("id") Optional<Integer> id) {
		
		if(id.isPresent())
			return new ResponseEntity<>(customerServices.retrieveCustomerById(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(customerServices.retrieveCustomers(), HttpStatus.OK);

	}
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer, BindingResult br) {
		return new ResponseEntity<>(customerServices.appendCustomer(customer), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeCustomer")
	public ResponseEntity<String> removeCustomer(@Valid @RequestBody Customer customer, BindingResult br) {
		customerServices.removeCustomer(customer);
		return new ResponseEntity<>("Id:"+customer.getIdCustomer(), HttpStatus.OK);
	}
}
