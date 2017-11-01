package pl.awolny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.CartItem;
import pl.awolny.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	
	public String delete(long id);
	public OrderItem findById(long id);
	public long findOrderItemIdByProductName(String name);
	public long findOrderItemIdByProductProductId(long id);
	public List<OrderItem> findAllByProductProductId(long id);

}
