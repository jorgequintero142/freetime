import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static Queue<String> queue = new PriorityQueue<>();

	static {
		queue.add("jorge");
		queue.add("luis");
		queue.add("yudy");
		queue.add("maria");
		queue.add("fernanda");
		queue.add("ana maria");
		queue.add("pedro");
		queue.add("guillermo");
		queue.add("antonio");
		queue.add("juan");
		queue.add("pacho");
		queue.add("candelaria");
		queue.add("gertrudis");
		queue.add("adriana");

	}

	public static void main(String[] args) throws InterruptedException {
		printCurrentQueue("Original..");

		while (!queue.isEmpty()) {
			System.out.println("Procesando " + queue.peek() + "...");
			queue.poll();

			Thread.sleep(1000);
			printCurrentQueue("Actual...");
		}
	}

	private static void printCurrentQueue(String msg) {
		System.out.println(msg + queue.toString());
	}

}