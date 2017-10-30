package pl.awolny.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.awolny.model.CartItem;
import pl.awolny.model.Product;
import pl.awolny.repository.CartItemRepository;
import pl.awolny.repository.ProductRepository;

@Service
public class CartItemService {
	
	@Autowired
	private CartItemRepository itemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void delete(long id){
		CartItem item = itemRepository.findById(id);
		item.setAmount(0);
		itemRepository.save(item);
	}
	
	public void setAmount(long id, int amount){
		CartItem item = itemRepository.findById(id);
		Product prod = item.getProduct();
		long unitsInStock = prod.getUnitsInStock() - amount;
		item.setAmount(amount);
		prod.setUnitsInStock(unitsInStock);
		productRepository.save(prod);
		save(item);
	}
	
	public void save(CartItem item){
		itemRepository.save(item);
	}
}