package pl.awolny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.awolny.service.ProductService;


@Controller
public class HomeController {
	
	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String home(Model model) {
   		model.addAttribute("products", productService.findAll());	
		return "products";
	}
	
	@GetMapping("/login")
	public String loginForm() {
	    return "login";
	}	
}