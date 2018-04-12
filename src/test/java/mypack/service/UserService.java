package mypack.service;

import mypack.beans.User;

public interface UserService {
	public User login(String userName,String password);
}
