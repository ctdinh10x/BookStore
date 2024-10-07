package com.example.BookManagement.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import com.example.BookManagement.Book;

public class UserDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/bookmanagement";
//	username mysql
	private String jdbcUsername = ""; 
//	password mysql
	private String jdbcPassword = ""; 
	
	private static final String SELECT_ALL_USERS = "select * from user";
	private static final String SELECT_USER_BY_USERNAME = "select * from user where USERNAME=?";
	private static final String INSERT_USER_SQL = "INSERT INTO user VALUES(?,?,?,?,?,?)";
	
	public UserDAO() {
		
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
	
	public int selectAllUsers(){
		int dem=0;
		try(Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				dem++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dem;
	}
	
	PasswordEncoder passwordEncoder;
	
	public String insertUser(User user) throws SQLException{
		passwordEncoder = new BCryptPasswordEncoder();
		String message = "";
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_USER_SQL);) {
			ps.setInt(1,selectAllUsers()+100);
			ps.setString(2, user.getUserName());
			ps.setString(3, passwordEncoder.encode(user.getPassWord()));
			ps.setString(4,user.getEmail());
			ps.setString(5,user.getPhoneNumber());
			ps.setString(6,"USER");
			ps.executeUpdate();
			message = "Tài khoản đã được thêm thành công";
		}
		catch (Exception e) {
			message = "Tên tài khoản đã bị trùng";
		}
		return message;
	}
	
	public User SelectUser(String UserName) {
		User user = new User();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);){
			preparedStatement.setString(1, UserName);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = Integer.valueOf(rs.getInt("ID"));
				String PassWord = rs.getString("PASSWORD");
				String Email = rs.getString("EMAIL");
				String PhoneNumber = rs.getString("PHONENUMBER");
				String Role = rs.getString("ROLE");
				user = new User(id,UserName,PassWord,Email,PhoneNumber,Role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> selectUser(String UserName) {
		ArrayList users = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);){
			preparedStatement.setString(1, UserName);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				int id = Integer.valueOf(rs.getInt("ID"));
				String PassWord = rs.getString("PASSWORD");
				String Email = rs.getString("EMAIL");
				String PhoneNumber = rs.getString("PHONENUMBER");
				String Role = rs.getString("ROLE");
				users.add(new User(id,UserName,PassWord,Email,PhoneNumber,Role));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
}
