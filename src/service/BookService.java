package service;

import java.util.List;

import pojo.Book;

public interface BookService {
	//调用list()实际是调用数据持久化层BookMapper中的list()
	public List<Book> list();//这里函数名与BookMapper中的名称无关
	public void add(Book book);
	public void delete(int bookId);
	public Book get(int booId);
	public void update(Book book);
}
