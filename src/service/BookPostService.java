package service;

import java.util.List;

import pojo.BookPost;
import pojo.User;

public interface BookPostService {
	public List<BookPost> bookpostList();
	public void addBookPost(BookPost bookpost,User user);
	public void deleteBookPost(int book_id);
	public BookPost getBookPost(int book_id);
	public void updateBookPost(BookPost bookpost);
}
