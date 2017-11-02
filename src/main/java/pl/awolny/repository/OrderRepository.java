package pl.awolny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.Order;
import pl.awolny.model.Product;
import pl.awolny.model.User;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	List<Order> getOrdersByUser(User user);


}
