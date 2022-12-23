
public class FactoryOperation {
	public AbstractOperation getOperationClass(char operator) {
		switch (operator) {
		case '+': {

			return new AdditionOperation();
		}

		case '-': {

			return new SubtractionOperation();
		}

		case '*': {

			return new MultiplicationOperation();
		}

		case '/': {

			return new DivisionOperation();
		}
		default:
			throw new IllegalArgumentException("Unexpected operator: " + operator);
		}
	}
}
