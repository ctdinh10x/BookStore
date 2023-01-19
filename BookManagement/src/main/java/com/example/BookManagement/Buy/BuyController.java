package com.example.BookManagement.Buy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.BookManagement.Book;
import com.example.BookManagement.BookDAO;
import com.example.BookManagement.Comment.Comment;
import com.example.BookManagement.User.User;
import com.example.BookManagement.User.UserDAO;

@Controller
public class BuyController {
	
	private BuyDAO buyDAO = new BuyDAO();
	private UserDAO userDAO = new UserDAO();
	private BookDAO bookDAO = new BookDAO();
	@GetMapping("/user/buys")
	public String getBuys(Model model) throws IOException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userName = authentication.getName();
		User user = userDAO.SelectUser(userName);
		List<Buy> buy = buyDAO.selectAllBuys(user.getId());
		model.addAttribute("buys",buy);
		return "/User/buy";
	}
	
	
	@GetMapping("/user/buy/{idbuy}")
	public String getBuy(Model model, @PathVariable String idbuy) {
		model.addAttribute("idbuy",idbuy);
		Buy buy = buyDAO.selectBuy(Integer.valueOf(idbuy));
		
		model.addAttribute("buy", buy);
		return "/User/buy-detail";
	}
	
	@GetMapping("/admin/statistic/{BookCode}")
	public String getBuyBookCode(Model model, @PathVariable String BookCode) {
		model.addAttribute("BookCode",BookCode);
		List<BuyTime> list_buy = buyDAO.selectBuy_BookCode(Integer.valueOf(BookCode));
		model.addAttribute("buys", list_buy);
		return "statistic-result";
	}
	
	@GetMapping("/admin/statistic/user/{IdUser}/book/{BookCode}")
	public String getBuyUser(Model model, @PathVariable String IdUser, @PathVariable String BookCode) {
		model.addAttribute("idUser",IdUser);
		List<BuyTime> list_buy = buyDAO.selectAllBuys_IDUSER(Integer.valueOf(IdUser),Integer.valueOf(BookCode));
		model.addAttribute("buys", list_buy);
		model.addAttribute("username",list_buy.get(0).getUserName());
		return "statistic-user";
	}
	
	@PostMapping("/user/buy/{BookCode}")
	public String addBuy(Model model,BuyTime buy, @PathVariable String BookCode) throws SQLException{
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    String userName = authentication.getName();
		User user = userDAO.SelectUser(userName);
		String error = buyDAO.insertBuyTime(buy,user.getId(),Integer.valueOf(BookCode));
		int Amount = buy.getAmount();
		Book book = bookDAO.selectBook(Integer.valueOf(BookCode));
		int SoLuongCon = book.getAmount() - Amount;
		buyDAO.updateAmount(book, SoLuongCon);
		return "redirect:/user/buys";
	}
	
	@DeleteMapping("/user/buy/delete/{idbuy}")
	public String deleBook(ModelMap model,Buy buy, @PathVariable String idbuy) throws SQLException {
		buy = buyDAO.selectBuy(Integer.valueOf(idbuy));
		Book book = bookDAO.selectBook(Integer.valueOf(buy.getBookCode()));
		int Amount = buy.getAmount();
		int SoLuongCon = book.getAmount() + Amount;
		buyDAO.updateAmount(book, SoLuongCon);
		buyDAO.deleteBuy(idbuy);
		return "redirect:/user/buys"; 
	}
}
