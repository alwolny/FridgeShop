package pl.awolny.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.awolny.model.CartItem;
import pl.awolny.model.Order;
import pl.awolny.model.OrderItem;
import pl.awolny.model.Product;
import pl.awolny.model.ShoppingCart;
import pl.awolny.model.User;
import pl.awolny.repository.OrderRepository;
import pl.awolny.repository.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ShoppingCartService cartService;
	
	@Autowired
	OrderItemService itemService;
	
	public void order(){
		User user = userService.getAuthUser();
		List<CartItem> items = user.getCart().getItems();
		List<OrderItem> orderItems = new LinkedList<>();
		BigDecimal price = new BigDecimal(0);
		price = cartService.getTotal(user);
		for (CartItem item : items) {
            if(item.getAmount()!=0){
            	OrderItem orderItem = new OrderItem(item.getAmount(), item.getProduct());
            	orderItems.add(orderItem);
            }
        }
   		Order order = new Order(user, orderItems, price);
   		orderRepository.save(order);
   		cartService.deleteItemsFromTheCart(user);
	}
}