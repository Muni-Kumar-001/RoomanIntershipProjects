package com.abhiBus;

import java.util.Scanner;

class busSeats{
	int seats[];
	busSeats(){
		seats = new int[30];
	}
}
//class customer implements Runnable{
class Customer{
	private String name;
	private busSeats seat;
	//private void display() {
	void display() {
		for(int i=0;i<40;i++) {
			for(int j=0;j<20;j++) {
				if(j==0 || j==19) {
					System.out.print("|");
				}
				else if(i==0 || i==39) {
					System.out.print("+");
				}
				else{
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
//	@Override
//	public void run() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Please enter your seat number :: ");
//	}
	
}
public class AbhiBus {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.display();
	}
}
