package webdriver.java.tests;

public class Threading implements Runnable {

	public Threading() {
		super();
	}

	@Override
	public void run() {
		int threadNo = 20;

		Thread[] threads = new Thread[threadNo];
		Runnable[] runners = new Runnable[threadNo];

		for (int i = 0; i < threadNo; i++) {
			runners[i] = new ZawadzkiSpam();
		}

		for (int i = 0; i < threadNo; i++) {
			threads[i] = new Thread(runners[i]);
		}

		for (int i = 0; i < threadNo; i++) {
			threads[i].start();
		}
	}

}
