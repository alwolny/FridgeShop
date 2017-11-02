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
	ProductService productService;
	
	@Autowired
	ShoppingCartService cartService;
	
	@Autowired
	OrderItemService itemService;
	
	public void order(){
		BigDecimal price = new BigDecimal(0);
		price = cartService.getTotal();
		List<OrderItem> orderItems = createOrderItems();
		setUnits(orderItems);
		createOrder(orderItems, price);
   		cartService.deleteItemsFromTheCart();
	}
	
	public List<OrderItem> createOrderItems(){
		User user = userService.getAuthUser();
		List<CartItem> items = user.getCart().getItems();
		List<OrderItem> orderItems = new LinkedList<>();
		for (CartItem item : items) {
            if(item.getAmount()!=0){
            	OrderItem orderItem = new OrderItem(item.getAmount(), item.getProduct());
            	orderItems.add(orderItem);
            }
        }
		return orderItems;
	}
	
	public void setUnits(List<OrderItem> orderItems){
		for(OrderItem item : orderItems){
			Product product = productService.getProductByProductId(item.getProduct().getProductId());
			product.setUnitsInOrder(product.getUnitsInOrder()+item.getAmount());
			product.setUnitsInStock(product.getUnitsInStock()-item.getAmount());
			productService.save(product);
		}
	}
	
	public void createOrder(List<OrderItem> orderItems, BigDecimal price){
		User user = userService.getAuthUser();
   		Order order = new Order(user, orderItems, price);
   		orderRepository.save(order);
	}
}