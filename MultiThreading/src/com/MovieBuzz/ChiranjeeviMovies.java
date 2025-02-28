package com.MovieBuzz;

public class ChiranjeeviMovies extends Thread {
	String cArr[] = {"Yamudiki Moguduzzz","Challenge","Pasivadi Pranam","Rowdy Alludu","Waltair Veeraya","Annayya","Kondaveeti Donga","Rate","Anji"};
	public void run() {
		for(int j=0;j<cArr.length;j++) {
			System.out.println("\tChiranjeevi -> "+cArr[j]);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
