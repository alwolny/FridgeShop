package pl.awolny.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import pl.awolny.model.Product;
import pl.awolny.model.User;
import pl.awolny.service.UserService;

public class UserControllerTest {
	@Mock
	private UserService userService;
	
	@InjectMocks
	private UserController userController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}
	
	@Test
	public void showUserTest() throws Exception{
		List<User> users = new ArrayList<>();
		users.add(new User());
		users.add(new User());
		users.add(new User());
		
		when(userService.getUsers()).thenReturn((List) users);
		
		mockMvc.perform(get("/list/users"))
			.andExpect(status().isOk())
			.andExpect(view().name("userList"))
			.andExpect(model().attribute("users", hasSize(3)));		
		assertThat(users.size(), not(equalTo(5)));
	}
}
