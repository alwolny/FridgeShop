package pl.awolny.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import pl.awolny.model.Product;
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
    
    @GetMapping("/userPage")
    public String getUserPage(Model model) {
    	User user = userService.getAuthUser();
        model.addAttribute("user", user);
        return "userPage";
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
    
    @RequestMapping("/deleteUser")
    public String delete() {
    	userService.deleteLoggedInUser();	
/*        model.addAttribute("product", new Product());
*/        return "redirect:logmeout";
    }
	
	@GetMapping("/list/users")
	public String showUsers(Model model) {
		List<User> users = userService.getUsers();
        model.addAttribute("users", users);
	    return "userList";
	}
}