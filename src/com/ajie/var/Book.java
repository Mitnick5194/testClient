package com.ajie.var;

/**
 * @author niezhenjie
 * 
 */
public class Book {
	private String bookname;
	private int price;
	public UserBean author;

	public Book(String bookname, int price, UserBean author) {
		this.bookname = bookname;
		this.price = price;
		this.author = author;
	}

	public Book() {
	}

	public String getBookname() {
		return bookname;
	}

	public int getPrice() {
		return price;
	}

	public UserBean getAuthor() {
		return author;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setAuthor(UserBean author) {
		this.author = author;
	};

	@Override
	public String toString() {
		return "bookname: " + bookname + " price: " + price + " author: {" + author.toString()
				+ "}";
	}

}
