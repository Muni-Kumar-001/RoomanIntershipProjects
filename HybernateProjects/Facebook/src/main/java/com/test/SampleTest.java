package com.test;

import com.user.UserImplementation;

public class SampleTest {
	public static void main(String[] args) {
		UserImplementation ui = new UserImplementation();
//		ui.register("Muni", "Kumar", "mk123", "muni@123");
		ui.register("Sai", "chetan", "ch123", "sai@123");
		ui.login("mk123", "muni@123");
	}
}
