package webdriver.java.tests;

public class main1 {

	public static void main(String args[]) {
		int threadNo = 5;

		Thread[] threads = new Thread[threadNo];
		Runnable[] runners = new Runnable[threadNo];

		for (int i = 0; i < threadNo; i++) {
			runners[i] = new Threading();
		}

		for (int i = 0; i < threadNo; i++) {
			threads[i] = new Thread(runners[i]);
		}

		for (int i = 0; i < threadNo; i++) {
			threads[i].start();
		}
	}
}
