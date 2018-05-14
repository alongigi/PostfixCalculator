/**
 * An exception class that intended for the PostfixCalculator.
 * Extends RuntimeException Class
 * used to throw an exception for illegal expressions in the  PostfixCalculator Class
 * @author Alon
 */
public class ParseException extends RuntimeException {
	/**
	 * Creates a new exception with the String given
	 * @param message the message of the exception
	 */
	public ParseException(String message){
		super(message);
	}

}
