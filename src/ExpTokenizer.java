import java.util.Enumeration;
/**
 * a class that implements the interface "Enumeration"
 * if direction is true, we will tokenize from left to right,
 * if direction is false, then we will tokenize from right to left.
 */
public class ExpTokenizer extends Object implements Enumeration<Object>  {
	//fields
	private String [] result;
	private boolean direction;
	private int index;

	/**
	 * Creates a new Exptokenizer and initializes an array of strings, containing the tokens of the postfix string given
	 * also initializes the direction as true, meaning 'left to right'
	 * @param exp a given postfix string
	 */
	public ExpTokenizer(String exp) {
		this.result = exp.split(" ");
		this.direction = true;
		this.index = 0;
	}
	/**
	 * Creates a new Exptokenizer and initializes an array of strings, containing the tokens of the postfix string given
	 * @param exp a given postfix string
	 * @param direction the direction of the reading(true= left to right , false = right to left)
	 */
	public ExpTokenizer(String exp,boolean direction) {
		result = exp.split(" ");
		this.direction = direction;
		if(!this.direction)
			this.index=result.length-1;
		else 
			this.index = 0;
	}

	/**
	 * Returns the next element of the Exptokenizer
	 * if the element is an operator, crates the right type of operator
	 * if the element is a number, creates a ValueToken
	 * @return the next element of the Exptokenizer
	 */
	public Object nextElement() {
		CalcToken resultToken = null;
		String token =  nextToken();
		if (token.equals("+"))
			resultToken =  new AddOp();
		else if (token.equals("*"))
			resultToken =  new MultiplyOp();
		else if (token.equals("/"))
			resultToken =  new DivideOp();
		else if (token.equals("^"))
			resultToken =  new PowOp();
		else if (token.equals("-"))       
			resultToken =  new SubtractOp();


		else 
			resultToken = new ValueToken(Double.parseDouble(token));			

		return resultToken;	 
	}

	@Override
	public boolean hasMoreElements() {
		if(this.direction)
			return (this.index != this.result.length);
		else
			return (this.index >= 0);
	}
	/**
	 * Return the next token of the ExpTokenizer
	 * changes the index for later
	 * @return the next token of the ExpTokenizer
	 */
	public String nextToken() {
		String ret;
		if(this.direction){
			ret= this.result[this.index];
			this.index++;
		}

		else{
			ret= this.result[this.index];
			this.index--;
		}
		return ret;
	}

	public boolean hasMoreTokens() {
		return hasMoreElements();
	}
	/**
	 * Counts the tokens of the Exptokenizer
	 * @return an integer represents the number of tokens
	 */
	public int countTokens() {
		if(this.direction)
			return (this.result.length - this.index);
		else
			return (this.index+1);
	}
	/**
	 * changes the index of the Exptokenizer to the given index
	 * @param index the given index 
	 */
	protected void setIndex(int index){
		if(index>=0)
			this.index=index;
	}
	/**
	 * a GETTER function, for the Reult array of strings
	 * @return  string[] result
	 */
	protected String[] getResult() {
		return this.result;
	}

}