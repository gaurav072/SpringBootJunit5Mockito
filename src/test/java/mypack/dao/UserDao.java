package mypack.dao;

import mypack.beans.User;

public class UserDao {

	public User auth(String name,String password) {
		return new User(1,name,password);
	}
}
