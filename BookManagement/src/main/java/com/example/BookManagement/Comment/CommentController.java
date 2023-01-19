package com.example.BookManagement.Comment;

import java.sql.SQLException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookManagement.User.User;
import com.example.BookManagement.User.UserDAO;

@Controller
public class CommentController {
	
	private CommentDAO commentDAO = new CommentDAO();
	private UserDAO userDAO = new UserDAO();

	@PostMapping("user/save/comment/{BookCode}")
	public String addComment(Model model,Comment comment, @PathVariable String BookCode) throws SQLException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userName = authentication.getName();
		User user = userDAO.SelectUser(userName);
		commentDAO.insertBookTime(comment,user.getId(),Integer.valueOf(BookCode));
		return "redirect:/user/book/{BookCode}";
//		String mess_error = bookDAO.insertBook(book);
//		if(mess_error.equals("Thêm sách thành công")) {
//			return "redirect:/admin/book";
//		}
//		else {
//			return "redirect:/book/save/{BookCode}/error";
//		}
	}
	
}
