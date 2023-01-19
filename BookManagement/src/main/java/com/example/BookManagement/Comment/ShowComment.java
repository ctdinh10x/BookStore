package com.example.BookManagement.Comment;

public class ShowComment {
	private String UserName;
	private int SoSao;
	private String NhanXet;
	private String ThoiGian;
	
	public ShowComment() {

	}


	public ShowComment(String userName, int soSao, String nhanXet, String thoiGian) {
		super();
		UserName = userName;
		SoSao = soSao;
		NhanXet = nhanXet;
		ThoiGian = thoiGian;
	}



	public String getThoiGian() {
		return ThoiGian;
	}


	public void setThoiGian(String thoiGian) {
		ThoiGian = thoiGian;
	}


	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public int getSoSao() {
		return SoSao;
	}

	public void setSoSao(int soSao) {
		SoSao = soSao;
	}

	public String getNhanXet() {
		return NhanXet;
	}

	public void setNhanXet(String nhanXet) {
		NhanXet = nhanXet;
	}
	
	
}
