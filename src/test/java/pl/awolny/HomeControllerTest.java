package pl.awolny;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.awolny.controller.HomeController;
import pl.awolny.model.Product;
import pl.awolny.service.ProductService;
import static org.hamcrest.Matchers.*;


public class HomeControllerTest {
	
	@Mock
	private ProductService productService;
	
	@InjectMocks
	private HomeController homeController;
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
	}
	
	@Test
	public void testList() throws Exception{
		List<Product> products = new ArrayList<>();
		products.add(new Product());
		products.add(new Product());
		
	
		when(productService.findAll()).thenReturn((List) products);
		
		mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("products"))
			.andExpect(model().attribute("products", hasSize(2)));
	}
}