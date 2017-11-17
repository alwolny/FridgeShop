package pl.awolny.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.awolny.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
    User findByEmail(String email);
	User findByFirstName(String name);
	List<User> findAll();
	void deleteUserById(long id);


}