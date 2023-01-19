package com.example.BookManagement.Buy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.BookManagement.Book;
import com.example.BookManagement.Comment.Comment;
import com.example.BookManagement.Comment.ShowComment;

public class BuyDAO {
	
	private String jdbcURL = "jdbc:mysql://localhost:3306/bookmanagement";
	private String jdbcUsername = "root";
	private String jdbcPassword = "chutamdinh0365";
	
	private static final String SELECT_ALL_BUYS = "select buy.idbuy,book.BookCode, book.Name, book.NumberOfPages, book.Img, book.Title, book.Author, book.Type, book.ReleaseDate, book.Painted, buy.Amount from book,buy,user where user.ID = buy.User and book.BookCode = buy.Book and buy.User = ?";
	private static final String SELECT_BUY = "select user.ID,buy.idbuy,book.BookCode, book.Name, book.NumberOfPages, book.Img, book.Title, book.Author, book.Type, book.ReleaseDate, book.Painted, buy.Amount from book,buy,user where user.ID = buy.User and book.BookCode = buy.Book and buy.idBuy = ?";
	private static final String INSERT_BUY_SQL = "INSERT INTO buy (User, Book, Amount, ThoiGian) VALUES (?,?,?,?);";
	private static final String DELETE_BUY_SQL = "DELETE from buy where idbuy=?";
	private static final String DELETE_BUY_BOOKCODE = "DELETE from buy where Book=?";
	private static final String UPDATE_BOOK_AMOUNT = "UPDATE book SET Amount=? where BookCode=?";
	private static final String SELECT_BUY_BOOKCODE = "select user.ID,user.USERNAME,buy.idbuy,buy.ThoiGian,book.BookCode, book.Name, book.NumberOfPages, book.Img, book.Title, book.Author, book.Type, book.ReleaseDate, book.Painted, buy.Amount from book,buy,user where user.ID = buy.User and book.BookCode = buy.Book and buy.Book = ?";
	private static final String SELECT_BUY_IDUSER = "select user.ID,user.USERNAME,buy.idbuy, buy.ThoiGian, book.BookCode, book.Name, book.NumberOfPages, book.Img, book.Title, book.Author, book.Type, book.ReleaseDate, book.Painted, buy.Amount from book,buy,user where user.ID = buy.User and book.BookCode = buy.Book and book.BookCode=? and buy.User = ?";
	
	public BuyDAO() {
		
	}
	
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
	
	public List<Buy> selectAllBuys(int iduser) {
		ArrayList <Buy> list_buy = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BUYS);){
			preparedStatement.setInt(1, iduser);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("buy.idbuy");
				int bookcode = rs.getInt("book.BookCode");
				String namebook = rs.getString("book.Name");
				String author = rs.getString("book.Author");
				String title = rs.getString("book.Title");
				String ngayphathanh = rs.getString("book.ReleaseDate");
				int numberofpages = rs.getInt("book.NumberOfPages");
				String type = rs.getString("book.Type");
				int amount = rs.getInt("buy.Amount");
				String mota = rs.getString("book.Painted");
				String img_url = rs.getString("book.Img");
				list_buy.add(new Buy(id,iduser,bookcode,namebook,author,title,ngayphathanh,numberofpages,type,mota,img_url,amount));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_buy;
	}
	
	
	
	public Buy selectBuy(int idbuy) {
		Buy buy = new Buy();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BUY);){
			preparedStatement.setInt(1, idbuy);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("buy.idbuy");
				int iduser = rs.getInt("user.ID");
				int bookcode = rs.getInt("book.BookCode");
				String namebook = rs.getString("book.Name");
				String author = rs.getString("book.Author");
				String title = rs.getString("book.Title");
				String ngayphathanh = rs.getString("book.ReleaseDate");
				int numberofpages = rs.getInt("book.NumberOfPages");
				String type = rs.getString("book.Type");
				int amount = rs.getInt("buy.Amount");
				String mota = rs.getString("book.Painted");
				String img_url = rs.getString("book.Img");
				buy = new Buy(id,iduser,bookcode,namebook,author,title,ngayphathanh,numberofpages,type,mota,img_url,amount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buy;
	}
	
	public List<BuyTime> selectAllBuys_IDUSER(int idUser, int BookCode) {
		ArrayList <BuyTime> list_buy = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BUY_IDUSER);){
			preparedStatement.setInt(1, BookCode);
			preparedStatement.setInt(2, idUser);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("buy.idbuy");
				String UserName = rs.getString("user.USERNAME");
				String ThoiGian = rs.getString("buy.ThoiGian");
				String namebook = rs.getString("book.Name");
				String author = rs.getString("book.Author");
				String title = rs.getString("book.Title");
				String ngayphathanh = rs.getString("book.ReleaseDate");
				int numberofpages = rs.getInt("book.NumberOfPages");
				String type = rs.getString("book.Type");
				int amount = rs.getInt("buy.Amount");
				String mota = rs.getString("book.Painted");
				String img_url = rs.getString("book.Img");
				list_buy.add(new BuyTime(id,idUser,UserName,ThoiGian,BookCode,namebook,author,title,ngayphathanh,numberofpages,type,mota,img_url,amount));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_buy;
	}
	
	public ArrayList<BuyTime> selectBuy_BookCode(int BookCode) {
		ArrayList <BuyTime> list_buy = new ArrayList<>();
		ArrayList <BuyTime> list_buy_result = new ArrayList<>();
		BuyTime getBuy = new BuyTime();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BUY_BOOKCODE);){
			preparedStatement.setInt(1, BookCode);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("buy.idbuy");
				int iduser = rs.getInt("user.ID");
				String ThoiGian = rs.getString("buy.ThoiGian");
				String UserName = rs.getString("user.USERNAME");
				String namebook = rs.getString("book.Name");
				String author = rs.getString("book.Author");
				String title = rs.getString("book.Title");
				String ngayphathanh = rs.getString("book.ReleaseDate");
				int numberofpages = rs.getInt("book.NumberOfPages");
				String type = rs.getString("book.Type");
				int amount = rs.getInt("buy.Amount");
				String mota = rs.getString("book.Painted");
				String img_url = rs.getString("book.Img");
				list_buy.add(new BuyTime(id,iduser,UserName,ThoiGian,BookCode,namebook,author,title,ngayphathanh,numberofpages,type,mota,img_url,amount));
			}
			boolean[] check = new boolean[list_buy.size()];
			for(int i=0;i<list_buy.size();i++) {
				check[i] = true;
			}
			for(int i=0;i<list_buy.size();i++) {
				if(check[i]) {
					int sum_amount = list_buy.get(i).getAmount();
					for(int j=i+1;j<list_buy.size();j++) {
						if(list_buy.get(j).getIdUser() == list_buy.get(i).getIdUser()) {
							sum_amount += list_buy.get(j).getAmount();
							check[j]=false;
						}
					}
					list_buy.get(i).setAmount(sum_amount);
					list_buy_result.add(list_buy.get(i));
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_buy_result;
	}
	
	

	public String insertBook(Buy buy, int iduser, int bookCode) throws SQLException{
		String error;
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_BUY_SQL);) {
			ps.setInt(1,iduser);
			ps.setInt(2,bookCode);
			ps.setInt(3,buy.getAmount());
			error = "Bạn đã đặt mua sách thành công!";
			ps.executeUpdate();
			ps.close();
			connection.close();
		}
		catch (Exception e) {
			error= "Đã có lỗi trong quá trình đặt mua";
			e.printStackTrace();
		}
		return error;
	}
	
	public String insertBuyTime(BuyTime buy, int iduser, int bookCode) throws SQLException{
		String error;
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_BUY_SQL);) {
			ps.setInt(1,iduser);
			ps.setInt(2,bookCode);
			ps.setInt(3,buy.getAmount());
			ps.setString(4,buy.getThoiGian());
			error = "Bạn đã đặt mua sách thành công!";
			ps.executeUpdate();
			ps.close();
			connection.close();
		}
		catch (Exception e) {
			error= "Đã có lỗi trong quá trình đặt mua";
			e.printStackTrace();
		}
		return error;
	}
	
	public void deleteBuy(String idbuy) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_BUY_SQL);) {
			ps.setInt(1, Integer.valueOf(idbuy));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteBuy_BookCode(String BookCode) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_BUY_BOOKCODE);) {
			ps.setInt(1, Integer.valueOf(BookCode));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateAmount(Book book, int Amount) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(UPDATE_BOOK_AMOUNT);) {
			ps.setInt(1, Amount);
			ps.setInt(2, book.getBookCode());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
