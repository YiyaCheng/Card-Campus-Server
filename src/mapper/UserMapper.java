package mapper;

import java.util.List;

import pojo.User;

public interface UserMapper {
	//定义User可以提供给用户进行哪些操作
	public List<User> userList();
	public void addUser(User user);
	public void deleteUser(String user_sno);
	public User getUserBySno(String user_sno);
	public void updateUser(User user);
}
