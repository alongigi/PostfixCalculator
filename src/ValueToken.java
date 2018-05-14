/**
 * Class that extends CalcToken and represents a numeric value token
 * @author Alon 
 */
public class ValueToken extends CalcToken {
	//fields
	private double value;

	/** constructor
	 * @param value a numeric double value*/
	public ValueToken(double value) {
		this.value=value;
	}
	/**
	 * Return the value of the token.
	 * @return the numeric value
	 */
	public double getValue(){
		return this.value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}

}
