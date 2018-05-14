/**
 * A class that represents the operator (^).
 * @author Alon
 */
public class PowOp extends BinaryOp {

	public PowOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double operate(double left, double right) {
		return Math.pow(left, right);
	}

	@Override
	public String toString() {
		return "^";
	}

}
