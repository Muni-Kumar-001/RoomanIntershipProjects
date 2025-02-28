package com.gym;

public class SampleTest {
	public static void main(String[] args) {
		User u1 = new User("Muni","Kumar","muniKumar","Muni@123");
		User u2 = new User("Sai","Chethan","SaiChethan","Sai@143");
		UserImpl ui = new UserImpl();
		System.out.println(ui.register(u1, 0));
		System.out.println(ui.register(u2, 1));
		ui.login("muniKumar", "Muni@123");
	}

}
