package pl.awolny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.awolny.model.Order;
import pl.awolny.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/order")
	public String order() {
	    orderService.order();
		return "products";
	}
	
	@GetMapping("/list/orders")
	public String showOrders(Model model) {
	    List<Order> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
		return "orderList";
	}
}
