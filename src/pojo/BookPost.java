package pojo;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

import mapper.BookPostMapper;
import mapper.UserMapper;

public class BookPost {
	User user;
	
	//String user_sno;
	int book_id;
	String book_img;
	String book_describe;
	String book_title;
	Timestamp book_time;
	
	
	
	public String getBook_title() {
		return book_title;
	}
	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}
	public User getUser() {
		
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_img() {
		return book_img;
	}
	public void setBook_img(String book_img) {
		this.book_img = book_img;
	}
	public String getBook_describe() {
		return book_describe;
	}
	public void setBook_describe(String book_describe) {
		this.book_describe = book_describe;
	}
	public Timestamp getBook_time() {
		return book_time;
	}
	public void setBook_time(Timestamp book_time) {
		this.book_time = book_time;
	}
	
}
