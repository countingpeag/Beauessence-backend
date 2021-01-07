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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beauessence.agenda.models.Employee;
import com.beauessence.agenda.services.EmployeeServices;

@RestController
@RequestMapping("employee")
public class EmployeeController {

	private EmployeeServices employeeServices;
	
	@Autowired
	public EmployeeController(EmployeeServices employeeServices) {
		this.employeeServices=employeeServices;
	}
	
	@GetMapping(value = {"/getEmployees", "/getEmployee/{id}"})
	public ResponseEntity<List<Employee>> retrieveEmployee(@PathVariable("id") Optional<Integer> id) {
		
		if(id.isPresent())
			return new ResponseEntity<>(employeeServices.retrieveEmployeeById(id), HttpStatus.OK);
		else
			return new ResponseEntity<>(employeeServices.retrieveAllEmployees(), HttpStatus.OK);
	}
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee, BindingResult br) {		
		return new ResponseEntity<>(employeeServices.apendEmployee(employee), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/removeEmployee")
	public ResponseEntity<String> removeEmployee(@RequestBody Employee employee) {
		employeeServices.removeEmployee(employee);
		return new ResponseEntity<>("Id:"+ employee.getIdEmployee(), HttpStatus.OK);
	}
	
	@PutMapping("/updateEmployee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<>(employeeServices.updateEmployee(employee), HttpStatus.OK);
	}
}
