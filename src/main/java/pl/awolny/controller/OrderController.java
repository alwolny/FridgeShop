package pl.awolny.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.awolny.model.Order;
import pl.awolny.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/order")
	public String order() {
	    orderService.order();
		return "redirect:list/orders";
	}
	
	@GetMapping("/list/orders")
	public String showOrders(Model model) {
	    List<Order> orders = orderService.getOrders();
	    List<Order> userOrders = orderService.getUserOrders();
        model.addAttribute("orders", orders);
        model.addAttribute("userOrders", userOrders);
		return "orderList";
	}
	
	@RequestMapping("/anorder")
	public String getOrdertById(@RequestParam("id") long orderId, Model model){
		model.addAttribute("order", orderService.getOrderById(orderId));
		model.addAttribute("orderItems", orderService.getOrderById(orderId).getOrderItems());
		return "order";
	}
}