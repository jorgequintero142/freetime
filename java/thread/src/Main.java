import threads.MiImplThread;
import threads.MyThread;

public class Main {

	public static void main(String[] args) throws Exception {

		System.out.println("starting demo threads");
		Thread.currentThread().sleep(1000);
		
		MyThread myThread1 = new MyThread("Thread 1");
		MyThread myThread2 = new MyThread("Thread 2");

		Thread withRunnable1 = new Thread(new MiImplThread(), "Runnable1");
		Thread withRunnable2 = new Thread(new MiImplThread(), "Runnable2");

		myThread1.start();
		myThread2.start();

		withRunnable1.start();
		withRunnable2.start();

		System.out.println("finish demo threads...I guess the other threads have not been finished");
	}
}