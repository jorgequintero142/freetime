
public class DivisionOperation extends AbstractOperation {

	@Override
	protected double exeOperation(double firstOperand, double secondOperand) {
		if (firstOperand == 0) {
			throw new IllegalStateException("zero cannot be a divisor");
		}
		return secondOperand / firstOperand;
	}

}
