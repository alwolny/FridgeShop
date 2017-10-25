package pl.awolny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import pl.awolny.model.ShoppingCart;
import pl.awolny.model.User;
import pl.awolny.model.UserRole;
import pl.awolny.repository.UserRepository;
import pl.awolny.repository.UserRoleRepository;

@Service
public class UserService {
	
    private static final String DEFAULT_ROLE = "ROLE_USER";
    private UserRepository userRepository;
    private UserRoleRepository roleRepository;
 
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
     
    @Autowired
    public void setRoleRepository(UserRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
	
	public void addUserWithCartAndDefaultRole(User user){
		UserRole defaultRole = roleRepository.findByRole(DEFAULT_ROLE);
        user.getRoles().add(defaultRole);
		user.setCart(new ShoppingCart());
		userRepository.save(user);
	} 
	public void save(User user){
		userRepository.save(user);
	}
	
	public User findByEmail(String email){
		return userRepository.findByEmail(email);
	}
	
	public User getAuthUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    return findByEmail(auth.getName());
	}
	
	public List<User> getUsers(){
		return userRepository.findAll();
	}
}