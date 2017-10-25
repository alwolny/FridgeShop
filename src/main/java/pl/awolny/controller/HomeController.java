package pl.awolny.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.awolny.model.CartItem;
import pl.awolny.model.Product;
import pl.awolny.model.ShoppingCart;
import pl.awolny.model.User;
import pl.awolny.repository.UserRepository;
import pl.awolny.service.ProductService;
import pl.awolny.service.ShoppingCartService;
import pl.awolny.service.UserService;

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
	
/*    @RequestMapping(value = "/image/{image_id}", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("image_id") Long imageId) throws IOException {
        byte[] imageContent = productService.getImageByProductId(imageId);; //get image from DAO based on id
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<byte[]>(imageContent, headers, HttpStatus.OK);
    }*/	
}