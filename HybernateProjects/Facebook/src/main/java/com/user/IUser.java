package com.user;

public interface IUser {
	public void register(String fName, String lName, String uName, String pswd);
	public boolean login(String uName, String pswd);
}
