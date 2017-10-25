package pl.awolny.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.awolny.model.Product;
import pl.awolny.model.User;
import pl.awolny.service.ProductService;
import pl.awolny.service.ShoppingCartService;
import pl.awolny.service.UserService;

@Controller
public class ShoppingCartController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ShoppingCartService cartService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/addToCart")
	public String addProductToCart(@RequestParam("name") String productName, Model model){
		Product prod = productService.getProductByName(productName);
	    User user = userService.getAuthUser();
		cartService.addProduct(user, prod);
		
		return "redirect:cart";
	}
	
	@RequestMapping("/cart")
	public String showCart(Model model) {
		User user = userService.getAuthUser();
		model.addAttribute("items", user.getCart().getItems());
	    BigDecimal sum = new BigDecimal(0);
		sum = cartService.getTotal(user);
		
	    model.addAttribute("total", sum);
		return "prod";
	}
}