package mapper;

import java.util.*;
import pojo.Book;

public interface BookMapper {
	//定义Book可以提供给用户进行哪些操作
	public List<Book> list();
	public void add(Book book);
	public void delete(int bookId);
	public Book get(int booId);
	public void update(Book book);
	
}
