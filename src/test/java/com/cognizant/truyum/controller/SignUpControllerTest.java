package com.cognizant.truyum.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.truyum.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class SignUpControllerTest {

	@Autowired
	private SignUpController signUpController;

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	ObjectMapper objectMapper;
	
	@Test
	void contextLoads() {
		assertNotNull(signUpController);
	}

	
	
	  @Test public void testSignUp() throws Exception { 
		  
	   User user = new User(); 
	   user.setId(1);
	   user.setUserName("admin1");
	   user.setPassword("pwd1");
	   this.mvc.perform(post("/users/adduser")
			   .contentType(MediaType.APPLICATION_JSON)
			   .content(objectMapper.writeValueAsString(user)))
	   		   .andExpect(content().string("added")); }
	 
}
