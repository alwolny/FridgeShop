package pl.awolny.service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import pl.awolny.model.CartItem;
import pl.awolny.model.Product;
import pl.awolny.model.ShoppingCart;
import pl.awolny.model.User;
import pl.awolny.repository.CartItemRepository;
import pl.awolny.repository.ShoppingCartRepository;

@Service
public class ShoppingCartService {

	@Autowired
	ShoppingCartRepository cartRepository;
	
	@Autowired
	CartItemRepository itemRepository;
	
	public void addProduct(User user, Product product){
		long check = checkIfInCart(user, product.getProductId());
		if (check == -1){		
			CartItem item = new CartItem();
			item.setProduct(product);
			item.setAmount(1);
			ShoppingCart cart = user.getCart();
			cart.getItems().add(item);
			cartRepository.save(cart);
		} else{
			CartItem item = itemRepository.findById(check);
			item.setAmount(item.getAmount()+1);
			itemRepository.save(item);
		}
	}
	
	public long checkIfInCart(User user, long id){
		ShoppingCart cart = user.getCart();
		List<CartItem> items = cart.getItems();
		for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			if (item.getProduct().getProductId()==id){
				return item.getId();
			}
		}
		return -1;
	}
	
	public BigDecimal getTotal(User user){
	    List<CartItem> items = user.getCart().getItems();
	    BigDecimal sum = new BigDecimal(0);
	    for (int i = 0; i < items.size(); i++) {
			CartItem item = items.get(i);
			for (int j = 0; j < item.getAmount(); j++){
				sum = sum.add(item.getProduct().getUnitPrice());
			}
	    }
	    return sum;
	}
}