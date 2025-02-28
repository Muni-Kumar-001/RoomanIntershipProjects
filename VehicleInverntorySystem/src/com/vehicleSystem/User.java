package com.vehicleSystem;

public class User {
	
	
	private String fName;
	private String lName;
	private String uName;
	private String pswd;
	
	
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	
	public User(String fName, String lName, String uName, String pswd) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.uName = uName;
		this.pswd = pswd;
	}
	
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", pswd=" + pswd + "]";
	}
	
	

}
