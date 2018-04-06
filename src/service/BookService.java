package service;

import java.util.List;

import pojo.Book;

public interface BookService {
	//����list()ʵ���ǵ������ݳ־û���BookMapper�е�list()
	public List<Book> list();//���ﺯ������BookMapper�е������޹�
	public void add(Book book);
	public void delete(int bookId);
	public Book get(int booId);
	public void update(Book book);
}
