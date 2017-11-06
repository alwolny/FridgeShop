package pl.awolny.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.awolny.model.Product;
import pl.awolny.service.ProductService;


@Controller
@RequestMapping("products")
public class ProductController{ 
	
	@Autowired
	private ProductService productService;

		
	@RequestMapping
	public String list(Model model){
		model.addAttribute("products", productService.findAll());
		return "products";
	}
	
	@RequestMapping("/all")
	public String allProducts(Model model){
		model.addAttribute("products", productService.findAll());
		return "products";
	}
	
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory){
		model.addAttribute("products", productService.getProductsByCategory(productCategory));
		return "products";
	}
	
	
	@RequestMapping("/product")
	public String getProductByName(@RequestParam("name") String productName, Model model){
		model.addAttribute("product", productService.getProductByName(productName));
		return "product";
	}
	
    @RequestMapping("/add")
    public String register(Model model) {
        model.addAttribute("product", new Product());
        return "addProduct";
    }
    
    @RequestMapping("/delete")
    public String delete(@RequestParam("id") long productId, Model model) {
    	productService.deleteById(productId);
    	
        model.addAttribute("product", new Product());
        return "redirect:/";
    }
 
    @PostMapping("/add")
    public String addUser(@ModelAttribute @Valid Product product,
            BindingResult bindResult) {
        if(bindResult.hasErrors())
            return "addProduct";
        else {
            productService.addProduct(product);
            return "registerSuccess";
        }
    }
}