package com.example.BookManagement;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookManagement.Buy.Buy;
import com.example.BookManagement.Buy.BuyController;
import com.example.BookManagement.Buy.BuyDAO;
import com.example.BookManagement.Buy.BuyTime;
import com.example.BookManagement.Comment.Comment;
import com.example.BookManagement.Comment.CommentDAO;
import com.example.BookManagement.Comment.ShowComment;
import com.example.BookManagement.User.User;
import com.example.BookManagement.service.CustomerUserDetailService;

@Controller
public class BookController {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookmanagement";
	private String jdbcUsername = "root";
	private String jdbcPassword = "chutamdinh0365";
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	private BookDAO bookDAO = new BookDAO();
	private CommentDAO commentDAO = new CommentDAO();
	private BuyDAO buyDAO = new BuyDAO();

	@GetMapping("/admin/book")
	public String getBooks(Model model) throws IOException{
		List<Book> book = bookDAO.selectAllBooks();
		model.addAttribute("books",book);
		return "books";
	}
	
	@GetMapping("/user/book")
	public String getBook(Model model) throws IOException{
		List<Book> book = bookDAO.selectAllBooks();
		model.addAttribute("books",book);
		return "/User/books";
	}
	
	@GetMapping("/admin/statistic")
	public String getBookStatistic(Model model) throws IOException{
		List<Book> book = bookDAO.selectAllBooks();
		model.addAttribute("books",book);
		return "statistic";
	}
	
	@GetMapping("/admin/book/search/{Name}")
	public String getBooks(Model model,@PathVariable String Name) throws IOException{
		model.addAttribute("Name",Name);
		List<Book> books = bookDAO.selectBookByName(Name);
		model.addAttribute("books",books);
		return "books";
	}
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/book/Login")
	public String getLogin(Model model) {
		return "/Login/Login_index";
	}
	
	@GetMapping("/book/SignUp")
	public String getSignUp(Model model) {
		model.addAttribute("user",new User());
		return "/SignUp/SignUp_index";
	}
	
	@GetMapping("/book/SignUp/Error")
	public String getSignUpError(Model model) {
		model.addAttribute("user",new User());
		return "/SignUp/SignUp_index_error";
	}
	
	@GetMapping("/book/SignUp/Success")
	public String getSignUpSucces(Model model) {
		model.addAttribute("user",new User());
		return "/SignUp/SignUp_index_success";
	}
	
	@GetMapping("/admin/book/{BookCode}")
	public String getBookAdmin(Model model, @PathVariable String BookCode) {
		model.addAttribute("BookCode",BookCode);
		Book book = bookDAO.selectBook(Integer.valueOf(BookCode));
		
		model.addAttribute("book", book);
		return "book-detail";
	}
	
	@GetMapping("/user/book/{BookCode}")
	public String getBookUser(Model model, @PathVariable String BookCode) {
		model.addAttribute("BookCode",BookCode);
		Book book = bookDAO.selectBook(Integer.valueOf(BookCode));
		model.addAttribute("book", book);
		List<ShowComment> list_comment = commentDAO.selectComment(Integer.valueOf(BookCode));
		model.addAttribute("comments", list_comment);
		Comment comment = new Comment();
		model.addAttribute("comment", comment);
		BuyTime buyTime = new BuyTime();
		model.addAttribute("buy", buyTime);
		String message = null;
		model.addAttribute("error", message);
		return "/User/book-detail";
	}
	
	@GetMapping("/admin/book/delete/{BookCode}")
	public String getDeleteBook(Model model, @PathVariable String BookCode) {
		model.addAttribute("BookCode",BookCode);
		Book book = bookDAO.selectBook(Integer.valueOf(BookCode));
		model.addAttribute("book", book);
		return "book-delete";
	}
	
	@DeleteMapping("/admin/book/delete/SaveDelete/{BookCode}")
	public String deleBook(ModelMap model, @PathVariable String BookCode) throws SQLException {
		buyDAO.deleteBuy_BookCode(BookCode);
		commentDAO.deleteComment(BookCode);
		bookDAO.deleteBook(BookCode);
		return "redirect:/admin/book"; 
	}
	
	@PostMapping("/admin/book/save/{BookCode}")
	public String addBook(Model model, Book book,@PathVariable String BookCode) throws SQLException{
		String mess_error = bookDAO.insertBook(book);
		if(mess_error.equals("Thêm sách thành công")) {
			return "redirect:/admin/book";
		}
		else {
			return "redirect:/book/save/{BookCode}/error";
		}
	}
	
	@GetMapping("/admin/book/save/{BookCode}/error")
	public String getBookError(Model model, @PathVariable String BookCode) {
		model.addAttribute("BookCode",BookCode);
		Book book = bookDAO.selectBook(Integer.valueOf(BookCode));
		model.addAttribute("book", book);
		return "book-detail_error";
	}
	
	@GetMapping("/admin/book/save/{BookCode}/success")
	public String getBookSuccess(Model model, @PathVariable String BookCode) {
		model.addAttribute("BookCode",BookCode);
		Book book = bookDAO.selectBook(Integer.valueOf(BookCode));
		model.addAttribute("book", book);
		return "book-detail_success";
	}


	@PutMapping("/admin/book/save/{bookcode}")
	public String updateBook(Book book,@PathVariable String bookcode) throws SQLException {
		bookDAO.updateBook(book);
		return "redirect:/admin/book";
	}
}
