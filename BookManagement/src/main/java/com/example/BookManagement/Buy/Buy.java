package com.example.BookManagement.Buy;

public class Buy {

	private int id;
	private int idUser;
	
	
	private int BookCode;
	private String Name;
	private String  Author;
	private String Title;
	private String ReleaseDate;
	private int NumberOfPages;
	private String Type;
	private String Decribe;
	private String Img;
	
	private int Amount;
	
	public Buy() {
		
	}

	public Buy(int id, int idUser, int bookCode, String name, String author, String title, String releaseDate,
			int numberOfPages, String type, String decribe, String img, int amount) {
		super();
		this.id = id;
		this.idUser = idUser;
		BookCode = bookCode;
		Name = name;
		Author = author;
		Title = title;
		ReleaseDate = releaseDate;
		NumberOfPages = numberOfPages;
		Type = type;
		Decribe = decribe;
		Img = img;
		Amount = amount;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getBookCode() {
		return BookCode;
	}

	public void setBookCode(int bookCode) {
		BookCode = bookCode;
	}
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getReleaseDate() {
		return ReleaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}

	public int getNumberOfPages() {
		return NumberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		NumberOfPages = numberOfPages;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getDecribe() {
		return Decribe;
	}

	public void setDecribe(String decribe) {
		Decribe = decribe;
	}

	public String getImg() {
		return Img;
	}

	public void setImg(String img) {
		Img = img;
	}

	public int getAmount() {
		return Amount;
	}

	public void setAmount(int amount) {
		Amount = amount;
	}
	
	
}
