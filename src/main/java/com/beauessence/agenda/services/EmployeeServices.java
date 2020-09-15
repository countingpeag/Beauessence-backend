package com.beauessence.agenda.services;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beauessence.agenda.models.Employee;
import com.beauessence.agenda.repositories.EmployeeRep;

@Service
public class EmployeeServices {
	
	@Autowired
	private EmployeeRep employeeRep;
	
	public List<Employee> retrieveEmployeeById(Optional<Integer> id){
		
		List<Employee> list = new LinkedList<Employee>();
		
		try {
			list.add(employeeRep.findById(id.get()).get());
		}
		catch(EntityNotFoundException ex) {
			throw new EntityNotFoundException(ex.getMessage());
		}
		catch(NoSuchElementException ex) {
			throw new EntityNotFoundException(ex.getMessage());
		}
		
		return list;
	}
	
	public List<Employee> retrieveAllEmployees(){
		return (List<Employee>) employeeRep.findAll();
	}

	public Employee apendEmployee(Employee employee) {
		return employeeRep.save(employee);
	}
	
	public void removeEmployee(Employee employee) {
		employeeRep.delete(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRep.save(employee);
	}
}
