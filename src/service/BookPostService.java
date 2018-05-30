package service;

import java.util.List;

import pojo.BookPost;
import pojo.User;

public interface BookPostService {
	public List<BookPost> bookpostList();
	public void addBookPost(BookPost bookpost);
	public void deleteBookPost(String book_id);
	public BookPost getBookPost(String book_id);
	public void updateBookPost(BookPost bookpost);
}
