package com.MovieBuzz;

public class BalayyaMovies extends Thread {
	String bArr[] = {"Akhanda","Bhagavanth Kesari","Gautamiputra Satakarni","Legend","Simha","Jai Simha","NTR Kathanayakuduz","Narasimha Naidu"};
	public void run() {
		for(int i=0;i<bArr.length;i++) {
			System.out.println("\tBalaya -> "+bArr[i]);
			try {
				Thread.sleep(1000);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
