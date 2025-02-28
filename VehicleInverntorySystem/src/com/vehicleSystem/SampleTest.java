package com.vehicleSystem;

import java.util.Scanner;
public class SampleTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to AUTOSHOP WORLD!!!");
		System.out.println("Please signup with your details");
		
		System.out.print("Please enter your first name :: ");
		System.out.print("");
		String fName = sc.nextLine();
		System.out.print("Please enter your second name :: ");
		String lName = sc.nextLine();
		System.out.print("Please enter your username :: ");
		String uName = sc.nextLine();
		System.out.print("Please enter your password :: ");
		String pswd = sc.nextLine();
		User u1 = new User(fName,lName,uName,pswd);
		
		UserImpl ui = new UserImpl();
		System.out.println(ui.register(u1));
		
		System.out.print("Please enter your username :: ");
		String uNameCheck = sc.nextLine();
		System.out.print("Please enter your password :: ");
		String pswdCheck  = sc.nextLine();
		
		if(ui.Login(uNameCheck, pswdCheck)) {
			System.out.println("Welcome to Autoshop world\n");
			Vehicle v1 = new Vehicle("Toyota",2019,5000);
			Vehicle v2 = new Vehicle("Suzuki",2016,3500);
			Vehicle v3 = new Vehicle("Benz",2021,6000);
			Vehicle v4 = new Vehicle("Kia",2020,4500);
			
			VehicleImpl vi = new VehicleImpl();
			vi.addVehicle(v1);
			vi.addVehicle(v2);
			vi.addVehicle(v3);
			vi.addVehicle(v4);
			
			vi.display(1);
			
			System.out.println("\nIf you want to please select from the following based on which you want");
			System.out.println("\t1.mfgYear\n\t2.vName\n\t3.price");
			System.out.print("Please enter your choice :: ");
			
			vi.display(sc.nextInt());
		}
		
		sc.close();
	}
}
