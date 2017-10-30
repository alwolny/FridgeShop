package pl.awolny.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.awolny.model.CartItem;
import pl.awolny.model.Order;
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
	
	public void order(){
		User user = userService.getAuthUser();
   		List<CartItem> orderItems = new LinkedList<>();
		List<CartItem> items = user.getCart().getItems();
		BigDecimal price = new BigDecimal(0);
		price = cartService.getTotal(user);
		for (CartItem item : items) {
            if(item.getAmount()!=0){
            	orderItems.add(item);
            }
        }		
   		Order order = new Order(user, orderItems, price);
   		System.out.println("total order price" + order.getTotal());
   		orderRepository.save(order);
   		cartService.deleteItemsFromTheCart(user);
	}
}
