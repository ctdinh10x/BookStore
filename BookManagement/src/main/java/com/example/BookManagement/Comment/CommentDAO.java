package com.example.BookManagement.Comment;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.example.BookManagement.Book;

public class CommentDAO {

	private String jdbcURL = "jdbc:mysql://localhost:3306/bookmanagement";
	private String jdbcUsername = "root";
	private String jdbcPassword = "chutamdinh0365";
	
	private static final String SELECT_ALL_COMMENTS_BY_BOOKCODE = "select user.UserName, comment.SoSao,  comment.NoiDung, comment.ThoiGian from user,comment where user.ID = comment.idUser and comment.BookCode = ?";
	private static final String INSERT_COMMENTS_SQL = "INSERT INTO comment (idUser, BookCode, SoSao, NoiDung) VALUES (?,?,?,?);";
	private static final String INSERT_TIME_COMMENTS_SQL = "INSERT INTO comment (idUser, BookCode, SoSao, NoiDung,ThoiGian) VALUES (?,?,?,?,?);";
	private static final String DELETE_COMMENTS_SQL = "DELETE from comment where BookCode=?";

	
	public CommentDAO() {
		
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
	
	public void insertBook(Comment comment, int iduser, int bookCode) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_COMMENTS_SQL);) {
			ps.setInt(1,iduser);
			ps.setInt(2,bookCode);
			ps.setInt(3,comment.getSoSao());
			ps.setString(4,comment.getNhanxet());
			ps.executeUpdate();
			ps.close();
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertBookTime(Comment comment, int iduser, int bookCode) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(INSERT_TIME_COMMENTS_SQL);) {
			ps.setInt(1,iduser);
			ps.setInt(2,bookCode);
			ps.setInt(3,comment.getSoSao());
			ps.setString(4,comment.getNhanxet());
			ps.setString(5,comment.getThoigian());
			ps.executeUpdate();
			ps.close();
			connection.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteComment(String BookCode) throws SQLException{
		try(Connection connection = getConnection();
				PreparedStatement ps = connection.prepareStatement(DELETE_COMMENTS_SQL);) {
			ps.setInt(1, Integer.valueOf(BookCode));
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<ShowComment> selectComment(int BookCode) {
		ArrayList <ShowComment> list_comment = new ArrayList<>();
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COMMENTS_BY_BOOKCODE);){
			preparedStatement.setInt(1, BookCode);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				String ThoiGian = rs.getString("comment.ThoiGian");
				String username = rs.getString("user.UserName");
				int sosao = rs.getInt("comment.SoSao");
				String nhanxet = rs.getString("comment.NoiDung");
				list_comment.add(new ShowComment(username,sosao,nhanxet,ThoiGian));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list_comment;
	}
}
