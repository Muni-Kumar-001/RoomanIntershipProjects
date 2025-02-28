package com.MovieBuzz;

import java.util.Scanner;

public class MovieBuzz extends Thread {

    void display() {
        System.out.println("***************Welcome to MovieBuzz***************\n");
        System.out.println("\t1. Chiranjeevi\n\t2. Balayya\n\t3. Prabhas\n\t4. All\n\t5. Exit");
        System.out.print("Please Enter your choice: ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        while (true) {
        	
            // Create movie thread objects for each actor
            ChiranjeeviMovies cm = new ChiranjeeviMovies();
            BalayyaMovies bm = new BalayyaMovies();
            PrabhasMovies pm = new PrabhasMovies();
            MovieBuzz mb = new MovieBuzz();

            mb.display();
            try {
                choice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine();
                continue;
            }

            // Handle user input based on their choice
            if (choice == 1) {
                cm.start();  // Start ChiranjeeviMovies thread
                try {
                    cm.join();  // Wait for ChiranjeeviMovies thread to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == 2) {
                bm.start();  // Start BalayyaMovies thread
                try {
                    bm.join();  // Wait for BalayyaMovies thread to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == 3) {
                pm.start();  // Start PrabhasMovies thread
                try {
                    pm.join();  // Wait for PrabhasMovies thread to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == 4) {
                cm.start();
                bm.start();
                pm.start();

                try {
                    cm.join();  // Wait for ChiranjeeviMovies thread to finish
                    bm.join();  // Wait for BalayyaMovies thread to finish
                    pm.join();  // Wait for PrabhasMovies thread to finish
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else if (choice == 5) {
                System.out.println("Thank you for visiting...");
                break;  // Exit the loop and terminate the program
            } else {
                System.out.println("Invalid choice. Please choose a valid option.");
            }
        }

        sc.close();
    }
}
