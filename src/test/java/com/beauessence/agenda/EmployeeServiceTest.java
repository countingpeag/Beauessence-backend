package com.beauessence.agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;
import java.util.Optional;

import com.beauessence.agenda.models.Employee;
import com.beauessence.agenda.repositories.EmployeeRep;
import com.beauessence.agenda.services.EmployeeServices;

import junit.framework.TestCase;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest  extends TestCase{

	@Mock
	private EmployeeRep empRepo;
	
	@InjectMocks
	private EmployeeServices empServices;
	
	private Employee employee;
	
	@BeforeEach
	public void init() {
		employee = new Employee();
		employee.setIdEmployee(1);
		employee.setName("Erick");
		employee.setLastName("Palma");
		employee.setPhone("3333333333");
		employee.setEmail("omar4335@gmail.com");
	}
	
	@Test
	public void saveEmployeeTest() {
		
		given(empRepo.save(employee)).willAnswer(invocation -> invocation.getArgument(0));
		
		Employee savedEmployee = empServices.apendEmployee(employee);
		
		assertThat(savedEmployee).isNotNull();	
		assertEquals(savedEmployee, employee);
		verify(empRepo, times(1)).save(employee);
		
	}
	
	@Test
	public void retrieveEmployeeTest() {
		given(empRepo.findById(employee.getIdEmployee())).willReturn(Optional.of(employee));

		List<Employee> employeeFound = empServices.retrieveEmployeeById(Optional.of(1));
		
		assertThat(employeeFound).isNotNull();
		assertEquals(employee, employeeFound.get(0));
		verify(empRepo, times(1)).findById(employee.getIdEmployee());
	}
	
	@Test
	public void updateEmployeeTest() {
		given(empRepo.save(employee)).willReturn(employee);
		
		Employee employeeUpdated = empServices.updateEmployee(employee);
		
		assertThat(employeeUpdated).isNotNull();
		assertEquals(employee, employeeUpdated);	
		verify(empRepo, times(1)).save(employee);
	}
	
	@Test
	public void deteleEmployeeTest() {
		empServices.removeEmployee(employee);
		verify(empRepo, times(1)).delete(employee);
	}
	
	
}
