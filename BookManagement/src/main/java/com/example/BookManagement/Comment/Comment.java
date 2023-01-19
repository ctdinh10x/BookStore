package com.example.BookManagement.Comment;

import java.util.Date;

public class Comment {
	
	private int Id;
	private int IdUser;
	private int BookCode;
	private int SoSao;
	private String nhanxet;
	private String thoigian;
	
	

	public Comment() {
		
	}

	public Comment(int id, int idUser, int bookCode, int soSao, String nhanxet, String thoigian) {
		super();
		Id = id;
		IdUser = idUser;
		BookCode = bookCode;
		SoSao = soSao;
		this.nhanxet = nhanxet;
		this.thoigian = thoigian;
	}





	public String getThoigian() {
		return thoigian;
	}

	public void setThoigian(String thoigian) {
		this.thoigian = thoigian;
	}

	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getIdUser() {
		return IdUser;
	}
	public void setIdUser(int idUser) {
		IdUser = idUser;
	}
	public int getBookCode() {
		return BookCode;
	}
	public void setBookCode(int bookCode) {
		BookCode = bookCode;
	}
	public int getSoSao() {
		return SoSao;
	}
	public void setSoSao(int soSao) {
		SoSao = soSao;
	}
	public String getNhanxet() {
		return nhanxet;
	}
	public void setNhanxet(String nhanxet) {
		this.nhanxet = nhanxet;
	}

}
