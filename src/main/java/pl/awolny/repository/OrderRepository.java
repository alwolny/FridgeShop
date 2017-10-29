package pl.awolny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.Order;
import pl.awolny.model.Product;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
