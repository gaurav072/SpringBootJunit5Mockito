package mypack.beans;

public class User {
	private int id;
	private String userName;
	private String password;
	
	public User() {
		super();
	}

	public User(int id,String userName, String password) {
		super();
		this.id= id;
		this.userName = userName;
		this.password = password;
	}
}
