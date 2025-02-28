package com.gym;

public class UserImpl implements IUser{
	
	User users[];
	UserImpl(){
		users = new User[5];
	}
	
	@Override
	public void login(String u, String pass) {
		for(User us:users) {
			if(!us.equals(null) && us.getUserName()==u && us.getPassWord()==pass) {
				System.out.println("Login successfull");
				return;
			}
		}
	}

	@Override
	public String register(User u,int index) {
		users[index] = u;
		return "your details with us";
	}

}
