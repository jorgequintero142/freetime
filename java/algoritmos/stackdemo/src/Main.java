import java.util.Stack;

public class Main {

	static Stack<String> stack = new Stack<>();

	static {
		stack.push("jorge");
		stack.push("luis");
		stack.push("yudy");
		stack.push("maria");
		stack.push("fernanda");
		stack.push("ana maria");
		stack.push("pedro");
		stack.push("guillermo");
		stack.push("antonio");
		stack.push("juan");
		stack.push("pacho");
		stack.push("candelaria");
		stack.push("gertrudis");
		stack.push("adriana");

	}

	public static void main(String[] args) throws InterruptedException {
		printCurrentStack("Original..");

		while (!stack.isEmpty()) {
			System.out.println("Procesando " + stack.peek() + "...");
			stack.pop();

			Thread.sleep(1500);
			printCurrentStack("Actual...");
		}
	}

	private static void printCurrentStack(String msg) {
		System.out.println(msg + stack.toString());
	}

}
