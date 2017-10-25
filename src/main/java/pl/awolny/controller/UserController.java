package pl.awolny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import pl.awolny.model.User;
import pl.awolny.service.UserService;
 
@Controller
public class UserController {
     
	@Autowired
    private UserService userService;
 
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registerForm";
    }
    
 
    @PostMapping("/register")
    public String addUser(@ModelAttribute @Valid User user,
            BindingResult bindResult) {
        if(bindResult.hasErrors())
            return "registerForm";
        else {
            userService.addUserWithCartAndDefaultRole(user);
            return "registerSuccess";
        }
    }  
    
	
	@GetMapping("/showUsers")
	public String showUsers(Model model) {
		List<User> users = userService.getUsers();
        model.addAttribute("users", users);
	    return "userList";
	}	
}