package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.UserMapper;
import pojo.User;
import service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;
	@Override
	public List<User> userList() {
		return userMapper.userList();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMapper.addUser(user);
	}

	@Override
	public void deleteUser(int user_sno) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(user_sno);
	}

	@Override
	public User getUserBySno(int user_sno) {
		// TODO Auto-generated method stub
		return userMapper.getUserBySno(user_sno);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userMapper.updateUser(user);
	}

}
