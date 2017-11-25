package pl.awolny.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.awolny.model.CartItem;
import pl.awolny.model.Product;
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
		user.setActive(true);
		String hashedPass = new BCryptPasswordEncoder().encode(user.getPassword());
		// = encoder.encode(user.getPassword());
		user.setPassword(hashedPass);
		userRepository.save(user);
		System.out.println(user.isActive());
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
	
	@Transactional
	public void deleteLoggedInUser() {
		User user = getAuthUser();
		user.setActive(false);
		userRepository.save(user);
	}

	public void setNewPassword(String new1) {
		User user = getAuthUser();
		String hashedPass = new BCryptPasswordEncoder().encode(new1);
		user.setPassword(hashedPass);
		userRepository.save(user);
	}
}