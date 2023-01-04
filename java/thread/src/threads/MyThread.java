package threads;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
	}

	@Override
	public void run() {
		System.out.println("I am the thread " + Thread.currentThread().getName());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.err.println("Error with " + Thread.currentThread().getName());
		}
		System.out.println("Bye bye " + Thread.currentThread().getName());
	}
}