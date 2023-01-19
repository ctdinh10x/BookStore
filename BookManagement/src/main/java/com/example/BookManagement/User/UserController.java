package com.example.BookManagement.User;

import java.io.IOException;
import java.sql.SQLException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	private UserDAO userDAO = new UserDAO();
	
	@PostMapping("/user/save/{UserName}")
	public String addUser(Model model,User user,@PathVariable String UserName) throws SQLException{
		String error = userDAO.insertUser(user);
		model.addAttribute("error", error);
		if(error.equals("Tài khoản đã được thêm thành công")) {
			return "redirect:/book/SignUp/Success";	
		}
		else {
			return "redirect:/book/SignUp/Error";
		}
	}
	
	@GetMapping("/accessDenied")
	public String getLogin(Model model) {
		return "accessDenied";
	}
	
	@GetMapping("/user/infor")
	public String getBooks(Model model) throws IOException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userName = authentication.getName();
		User user = userDAO.SelectUser(userName);
		model.addAttribute("user",user);
		return "user";
	}
}
