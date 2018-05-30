package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.BookPost;
import pojo.User;

public interface BookPostMapper {
	public List<BookPost> bookpostList();
	//��������������ע��
	public void addBookPost(BookPost bookpost);
	public void deleteBookPost(String book_id);
	public BookPost getBookPost(String book_id);
	public void updateBookPost(BookPost bookpost);
}
