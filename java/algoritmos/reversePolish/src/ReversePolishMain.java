import java.util.HashSet;
import java.util.Stack;

public class ReversePolishMain {

	static HashSet<Character> operators = new HashSet<>();
	static Stack<Double> stackNumbers;
	static {
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
		stackNumbers = new Stack<>();
	}

	public static void main(String[] args) {

		String rpn;
		if (args.length > 0) {
			rpn = args[0];
		} else {
			// result = 14
			rpn = "12-";
		}
		for (int y = 0; y < rpn.length(); y++) {
			char currentChar = rpn.charAt(y);
			if (isOperation(currentChar)) {
				double tmpResult = doOperation(currentChar);
				stackNumbers.add(tmpResult);
			} else {
				stackNumbers.add(Double.parseDouble("" + currentChar));
			}
		}

		String result = String.format("The result of '%s' is %s", rpn, stackNumbers.pop());
		System.out.println(result);

	}

	private static boolean isOperation(char currentChar) {
		return operators.contains(currentChar);
	}

	private static double doOperation(char operator) {
		AbstractOperation operation = new FactoryOperation().getOperationClass(operator);
		return operation.exeOperation(stackNumbers.pop(), stackNumbers.pop());
	}
}
