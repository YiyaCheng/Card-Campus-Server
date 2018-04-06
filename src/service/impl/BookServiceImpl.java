package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.BookMapper;
import pojo.Book;
import service.BookService;
//告诉spring这是一个实现类
@ Service
public class BookServiceImpl implements BookService {
	
	@Autowired//自动帮我们new BookMapper的实例化对象 
	BookMapper bookMapper;
	//spring注解将属性实例化
	
	@Override
	public List<Book> list() {
		return bookMapper.list();
	}

	@Override
	public void add(Book book) {
		bookMapper.add(book);

	}

	@Override
	public void delete(int bookId) {
		bookMapper.delete(bookId);

	}

	@Override
	public Book get(int booId) {
		return bookMapper.get(booId);
	}

	@Override
	public void update(Book book) {
		bookMapper.update(book);

	}

}
