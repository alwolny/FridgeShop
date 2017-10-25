package pl.awolny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	public String delete(long id);
	public CartItem findById(long id);
	public long findCartItemIdByProductName(String name);
	public long findCartItemIdByProductProductId(long id);
	//public List<CartItem> findAllByProductProductId(long id);
	public List<CartItem> findAllByProductProductId(long id);

}
