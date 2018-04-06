package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.BookMapper;
import pojo.Book;
import service.BookService;
//����spring����һ��ʵ����
@ Service
public class BookServiceImpl implements BookService {
	
	@Autowired//�Զ�������new BookMapper��ʵ�������� 
	BookMapper bookMapper;
	//springע�⽫����ʵ����
	
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
