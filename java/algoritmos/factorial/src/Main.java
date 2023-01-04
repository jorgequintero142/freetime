
public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		int number = 5;
		int factorial = m.factorial(number);
		System.out.println(String.format("The factorial of %d is %d", number, factorial));
	}

	private int factorial(int number) {
		if (number > 1) {
			return number * factorial(number - 1);
		} else {
			return 1;
		}
	}
}