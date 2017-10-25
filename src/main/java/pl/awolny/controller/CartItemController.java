package pl.awolny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.awolny.model.CartItem;
import pl.awolny.model.Product;
import pl.awolny.repository.CartItemRepository;
import pl.awolny.repository.ProductRepository;
import pl.awolny.service.CartItemService;

@Controller
public class CartItemController {
	
	@Autowired
	private CartItemService itemService;	
	
	@RequestMapping("/deleteItem")
	public String delete(@RequestParam("id") long itemId){
		itemService.delete(itemId);
		return "redirect:cart";
	}
	
	@RequestMapping("/setAmount")
	public String setAmount(@RequestParam("id") long itemId, @RequestParam("amount") int amount){
		itemService.setAmount(itemId, amount);
		return "redirect:cart";
	}
}