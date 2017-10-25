package pl.awolny.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.awolny.model.CartItem;
import pl.awolny.model.Product;
import pl.awolny.model.User;
import pl.awolny.model.UserRole;
import pl.awolny.repository.CartItemRepository;
import pl.awolny.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CartItemRepository itemRepository;
	
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List <Product> findAll(){
    	return productRepository.findAll();
    }

	public Product getProductByName(String productName) {
		return productRepository.getProductByName(productName);
	}

	public List<Product> getProductsByCategory(String productCategory) {
		return productRepository.getProductsByCategory(productCategory);
	}

	public Product getProductByProductId(long productId) {
		return productRepository.getProductByProductId(productId);
	}
	
	@Transactional
	public void deleteById(long id) {
		List<CartItem> list = itemRepository.findAllByProductProductId(id);
		for (int i = 0; i < list.size(); i++) {
			CartItem item = list.get(i);
			item.setAmount(0);
			itemRepository.save(item);
	    }
		
		Product product = productRepository.getProductByProductId(id);
		product.setDiscontinued(true);
		productRepository.save(product);
	}

	public byte[] getImageByProductId(long id) {
		return productRepository.getImageByProductId(id);
	}


	/*
	Product getProductByName(String productId);
	List<Product> getProductByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);*/

}