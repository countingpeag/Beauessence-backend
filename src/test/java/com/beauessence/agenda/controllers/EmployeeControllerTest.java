package com.beauessence.agenda.controllers;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.beauessence.agenda.controllers.EmployeeController;
import com.beauessence.agenda.models.Employee;
import com.beauessence.agenda.services.EmployeeServices;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@MockBean
	private EmployeeServices empService;
	
	private Employee employee1;
	private Employee employee2;
	
	@BeforeEach
	public void init(){
		employee1 = new Employee();
		employee1.setIdEmployee(1);
		employee1.setName("Erick");
		employee1.setLastName("Palma");
		employee1.setPhone("3333333333");
		employee1.setEmail("omar4335@gmail.com");
		
		employee2 = new Employee();
		employee2.setIdEmployee(2);
		employee2.setName("Omar");
		employee2.setLastName("Nuñez");
		employee2.setPhone("3333333333");
		employee2.setEmail("countingpeag56@gmail.com");
		
	}
	
	
	@Test
	public void getEmployeeTest() throws Exception {
		
		
		List<Employee> employees = Arrays.asList(employee1);
		
		
		given(empService.retrieveEmployeeById(Optional.of(employee1.getIdEmployee())))
		.willReturn(employees);
		
		mvc.perform(get("/employee/getEmployee/"+employee1.getIdEmployee()).contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].name", is("Erick")));
	}
	
	@Test
	public void getAllEmployeesTest() throws Exception {
		
		List<Employee> employees = Arrays.asList(employee1, employee2);
		
		given(empService.retrieveAllEmployees()).willReturn(employees);
		
		mvc.perform(get("/employee/getEmployees/").contentType(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
	}
	
	@Test
	public void addEmployeeTest() throws Exception {
		given(empService.apendEmployee(employee1)).willReturn(employee1);
		
		mvc.perform(post("/employee/addEmployee").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1)))
		.andExpect(status().isCreated());
	}
	
	@Test
	public void deleteEmployeeTest() throws Exception {
		
		doNothing().when(empService).removeEmployee(employee1);
		
		mvc.perform(delete("/employee/removeEmployee").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1)))
		.andExpect(status().isOk());
	}
	
	public void updateEmployeeTest() throws Exception{
		given(empService.updateEmployee(employee1)).willReturn(employee1);
		
		mvc.perform(put("/employee/updateEmployee").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee1)))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$", is(employee1)));
	}

}
