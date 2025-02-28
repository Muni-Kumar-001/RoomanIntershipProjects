package com.vehicleSystem;

import java.util.ArrayList;

public class UserImpl implements IUser{
	
	ArrayList<User> users;
	
	UserImpl(){
		users = new ArrayList<>();
	}
	
	@Override
	public boolean Login(String uName, String pswd) {
		for(User us: users) {
			if(us.getuName().equals(uName) && us.getPswd().equals(pswd))
				return true;
		}
		return false;
	}

	@Override
	public String register(User u) {
		users.add(u);
		return "Thank you... your registration success!!!";
	}

}
