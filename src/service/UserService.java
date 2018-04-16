package service;

import java.util.List;

import pojo.User;

public interface UserService {
	public List<User> userList();
	public void addUser(User user);
	public void deleteUser(int user_sno);
	public User getUserBySno(int user_sno);
	public void updateUser(User user);
	
}
