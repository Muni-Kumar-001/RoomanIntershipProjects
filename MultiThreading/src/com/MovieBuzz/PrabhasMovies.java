package com.MovieBuzz;

public class PrabhasMovies extends Thread {
	String pArr[] = {"chatrapathi","Eswar","Bahubali-1","Bahubali-2","saaho","Salar","Darling","Murari","Adivi Ramudu","Kalki 2898A.D."};
	public void run() {
		for(int i=0;i<pArr.length;i++) {
			System.out.println("\tPrabhas -> "+pArr[i]);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
