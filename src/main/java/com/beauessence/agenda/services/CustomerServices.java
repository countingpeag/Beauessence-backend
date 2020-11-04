package com.beauessence.agenda.services;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauessence.agenda.models.Customer;
import com.beauessence.agenda.repositories.CustomerRep;

@Service
public class CustomerServices {

	private CustomerRep customerRep;
	
	@Autowired
	public CustomerServices(CustomerRep customerRep) {
		this.customerRep=customerRep;
	}
	
	public List<Customer> retrieveCustomerById(Optional<Integer> id) {
		List<Customer> list = new LinkedList<Customer>();

		try {
			list.add(customerRep.findById(id.get()).get());
		}
		catch(EntityNotFoundException ex) {
			throw new EntityNotFoundException(ex.getMessage());
		}
		catch(NoSuchElementException ex) {
			throw new EntityNotFoundException(ex.getMessage());
		}
		
		return list;
	}
	
	public List<Customer> retrieveCustomers() {
		return (List<Customer>) customerRep.findAll();
	}
	
	public Customer appendCustomer(Customer customer) {
		return customerRep.save(customer);
	}
	
	public void removeCustomer(Customer customer) {
		customerRep.delete(customer);
	}
	
	public Customer updateCustomer(Customer customer) {
		return customerRep.save(customer);
	}
}
