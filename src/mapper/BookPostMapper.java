package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import pojo.BookPost;
import pojo.User;

public interface BookPostMapper {
	public List<BookPost> bookpostList();
	//��������������ע��
	public void addBookPost(@Param("bookpost")BookPost bookpost,@Param("user")User user);
	public void deleteBookPost(int book_id);
	public BookPost getBookPost(int book_id);
	public void updateBookPost(BookPost bookpost);
}
