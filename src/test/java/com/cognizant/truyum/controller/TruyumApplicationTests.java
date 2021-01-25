package com.cognizant.truyum.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.cognizant.truyum.controller.CartController;
import com.cognizant.truyum.controller.MenuItemController;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringJUnit4ClassRunner.class)
class TruyumApplicationTests {

	@Autowired
	private MenuItemController menuItemController;

	@Autowired
	private CartController cartController;

	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads() {
		assertNotNull(menuItemController);
	}
	@Test
	@WithMockUser(username="admin",roles={"ADMIN"})
	public void testGetMenuItemAdmin() throws Exception {
		ResultActions actions = mvc.perform(get("/menu-item"));
		actions.andExpect(status().isOk());
		//actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$[4].id").exists());
	}
	
	@Test
	@WithMockUser(username="user",roles={"USER"})
	public void testGetMenuItemCustomer() throws Exception {
		ResultActions actions = mvc.perform(get("/menu-item"));
		actions.andExpect(status().isOk());
		//actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$[5].id").doesNotExist());
	}

	@Test
	@WithMockUser(username="admin",roles={"USER","ADMIN"})
	public void testGetAdminException() throws Exception {
		ResultActions actions = mvc.perform(get("/menu-items/admin/10"));
		actions.andExpect(status().isNotFound());

	}

}
