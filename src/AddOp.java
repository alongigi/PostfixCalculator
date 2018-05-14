/**
 * A class that represents the operator (+).
 * @author Alon
 */
public class AddOp extends BinaryOp {

	public AddOp() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public double operate(double left, double right) {
		return left+right;
	}

	@Override
	public String toString() {
		return "+";
	}

}
