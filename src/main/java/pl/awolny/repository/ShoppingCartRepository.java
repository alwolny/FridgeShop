package pl.awolny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.ShoppingCart;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long>{

}
