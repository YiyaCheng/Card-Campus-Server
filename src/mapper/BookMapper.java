package mapper;

import java.util.*;
import pojo.Book;

public interface BookMapper {
	//����Book�����ṩ���û�������Щ����
	public List<Book> list();
	public void add(Book book);
	public void delete(int bookId);
	public Book get(int booId);
	public void update(Book book);
	
}
