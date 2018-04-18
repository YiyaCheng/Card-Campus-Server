package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.BookPostMapper;
import mapper.UserMapper;
import pojo.BookPost;
import pojo.User;
import service.BookPostService;
@Service
public class BookPostServiceImpl implements BookPostService {

	@Autowired
	BookPostMapper bookpostMapper;
	
	@Override
	public List<BookPost> bookpostList() {
		// TODO Auto-generated method stub
		return bookpostMapper.bookpostList();
	}

	@Override
	public void addBookPost(BookPost bookpost,User user) {
		// TODO Auto-generated method stub
		bookpostMapper.addBookPost(bookpost, user);
	}

	@Override
	public void deleteBookPost(int book_id) {
		// TODO Auto-generated method stub
		bookpostMapper.deleteBookPost(book_id);
	}

	@Override
	public BookPost getBookPost(int book_id) {
		// TODO Auto-generated method stub
		return bookpostMapper.getBookPost(book_id);
	}

	@Override
	public void updateBookPost(BookPost bookpost) {
		// TODO Auto-generated method stub
		bookpostMapper.updateBookPost(bookpost);
	}

}
