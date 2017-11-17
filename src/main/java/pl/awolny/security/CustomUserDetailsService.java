package pl.awolny.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import pl.awolny.exceptions.UserNotActiveException;
import pl.awolny.model.User;
import pl.awolny.model.UserRole;
import pl.awolny.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
    
    private UserRepository userRepository;
     
    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
 
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if(user == null)
            throw new UsernameNotFoundException("Niepoprawny login lub hasło");
        if(!user.isActive())
            throw new UserNotActiveException("Konto zostało usunięte");        
        org.springframework.security.core.userdetails.User userDetails = 
                new org.springframework.security.core.userdetails.User(
                        user.getEmail(), 
                        user.getPassword(), 
                        convertAuthorities(user.getRoles()));
        return userDetails;
    }
     
    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> userRoles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for(UserRole ur: userRoles) {
            authorities.add(new SimpleGrantedAuthority(ur.getRole()));
        }
        return authorities;
    }
}