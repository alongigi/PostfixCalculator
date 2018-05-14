/**
 * Abstract class describing a kind of calculator
 * @author Alon
 */
public abstract class Calculator {


	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Calculates the postfix expression given and saves the result to a stack
	 * @param expr a postfix expression String.
	 */
	public abstract void evaluate(String expr);
	/**
	 * Returns the final result from the stack
	 * @return the top element sitting within the stack, which is the final result
	 */
	public abstract  double getCurrentResult();

}
