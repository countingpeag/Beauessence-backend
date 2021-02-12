package com.beauessence.agenda;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class AgendaApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private com.beauessence.agenda.controllers.EmployeeController empC;
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void greetingDefault() throws Exception {
		this.mockMvc.perform(get("/employee/sayhi")).andDo(print()).andExpect(status().isOk())
		.andExpect(content().string(containsString("Hi, it's me")));
	}
	
	@Test
	public void EmployeeController() {
		assertThat(empC).isNotNull();
	}

}
