package com.Synchronization;

import java.util.Scanner;

class Account{
	//Fields
	private long acc_no;
	private double balance;
	private String ifsc_code;
	
	//To set the values
	Account(long acc_no,double balance,String ifsc_code){
		this.acc_no = acc_no;
		this.balance = balance;
		this.ifsc_code = ifsc_code;
	}
	
	//To check balance
	boolean ifSufficientBalance(int amt) {
		if(balance>amt) return true;
		return false;
	}
	//To withdraw amt from balance
	void withDraw(int amt) {
		balance-=amt;
		System.out.println("Current balance is " + balance);
	}
	
	
}
class Customer implements Runnable{
	//Fiels or properties
	private String name;
	private Account acc;
	
	//To set the values
	Customer(String name, Account acc){
		this.name = name;
		this.acc = acc;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter your amout :: ");
		int amt = sc.nextInt();
		synchronized(acc){
			if(acc.ifSufficientBalance(amt)) {
				acc.withDraw(amt);
			}
			else {
				System.out.println("Sorry! Insufficient Balance...");
			}
		}
	}
	
}

public class SynchronizationDemo {

	public static void main(String[] args) {
		Account ac = new Account(1026101000,10500.00,"UNI305D3701");
		Customer c1 = new Customer("sai",ac);
		Customer c2 = new Customer("muni",ac);
		
		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);
		
		t1.start();
		t2.start();
	}

}
