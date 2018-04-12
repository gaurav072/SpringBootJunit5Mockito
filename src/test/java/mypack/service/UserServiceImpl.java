package mypack.service;

import mypack.beans.User;
import mypack.dao.UserDao;

public class UserServiceImpl implements UserService{
	UserDao dao;
	
	public UserServiceImpl() {
		
	}
	public UserServiceImpl(UserDao userDao) {
		dao = userDao;
	}
	public User login(String username,String password) {
		return dao.auth( username, password);
	}
}
