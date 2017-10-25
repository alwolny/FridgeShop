package pl.awolny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findAll();	
	Product getProductByName(String name);
	Product getProductByProductId(long productId);
	List<Product> getProductsByCategory(String category);
	void deleteProductByProductId(long productId);
	public byte[] getImageByProductId(long productId);
}