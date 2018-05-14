/**
 * A class of a Postfix Calculator, intended to calculate postfix expressions
 */
public class PostfixCalculator extends Calculator {
	private StackAsArray stack=new StackAsArray();

	public PostfixCalculator() {
	}

	/**Helping function. counts the number of dots in a given string
	 * @param s A string
	 * @return the number of dots in the string given*/
	private static int countDots(String s){
		int counter=0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='.')
				counter+=1;
		}
		return counter;
	}

	/**Helping function.Returns whether or not the given char is found within the given String
	 * @param c a char
	 * @param s a String
	 * @return true if the char is found within the string, false if not*/
	private static boolean findCharInString(char c,String s){
		boolean ans=false;

		for (int i = 0; i < s.length(); i++) {
			if(c==s.charAt(i))
				ans=true;
		}
		return ans;
	}

	@Override
	public void evaluate(String expr) {
		ExpTokenizer e=new ExpTokenizer(expr, true);
		//************************************ Exceptions Check ************************************************
		String validChars="0123456789+-*/^.";
		String validDigits="0123456789";
		String validOperators="+-*/^";

		for (int i = 0; i < e.getResult().length; i++) {
			if(e.getResult()[i].length()==1){
				if(!findCharInString(e.getResult()[i].charAt(0), validChars))
					throw new ParseException("SYNTAX ERROR: invalid token "+e.getResult()[i]+" "); 
				else{
					if(findCharInString(e.getResult()[i].charAt(0), validDigits) && e.getResult().length==1)
						throw new ParseException("SYNTAX ERROR: can't perform operation on the number "+e.getResult()[i]+" alone"+" ");
					if(findCharInString(e.getResult()[i].charAt(0), validOperators) && e.getResult().length==1)
						throw new ParseException("SYNTAX ERROR: lone operetor "+e.getResult()[i]+" ");
				}

			}
			else{
				for (int j = 0; j < e.getResult()[i].length(); j++) {
					if(!findCharInString(e.getResult()[i].charAt(j), validChars))
						throw new ParseException("SYNTAX ERROR: invalid token "+e.getResult()[i]+" ");
				}
			}

		}
		if(e.getResult().length==0)
			throw new ParseException("SYNTAX ERROR: empty string ");

		for (int i = 0; i < e.getResult().length; i++) {
			if(countDots(e.getResult()[i])>1)
				throw new ParseException("SYNTAX ERROR: invalid number"+" "+e.getResult()[i]+" ");
		}
		e.setIndex(0); //


		if(e.getResult().length<=2)
			throw new ParseException("SYNTAX ERROR: cannot perform operation on the string ");  

		e.setIndex(0);
		//******************************************************************************************************
		while (e.countTokens()>0){
			Object next=e.nextElement();
			if(next.toString()=="+" || next.toString()=="-" || next.toString()=="*" || next.toString()=="/" || next.toString()=="^"){
				Object pop1=stack.pop();
				Object pop2=stack.pop();

				if(next instanceof AddOp){
					AddOp newnext=new AddOp();
					newnext=(AddOp)next;
					if(pop2 instanceof Double && !(pop1 instanceof Double))
						stack.push(newnext.operate((((Double) pop2).doubleValue()), ((ValueToken) pop1).getValue()));
					if(pop1 instanceof Double && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((Double) pop1).doubleValue()));
					if(pop1 instanceof Double && pop2 instanceof Double)
						stack.push(newnext.operate((((Double) pop2).doubleValue()), (((Double) pop1).doubleValue())));
					else if(!(pop1 instanceof Double) && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((ValueToken) pop1).getValue()));
					newnext=null;
				}
				else if(next instanceof SubtractOp){
					SubtractOp newnext=new SubtractOp();
					newnext=(SubtractOp)next; 
					if(pop2 instanceof Double && !(pop1 instanceof Double))
						stack.push(newnext.operate((((Double) pop2).doubleValue()), ((ValueToken) pop1).getValue()));
					if(pop1 instanceof Double && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((Double) pop1).doubleValue()));
					if(pop1 instanceof Double && pop2 instanceof Double)
						stack.push(newnext.operate((((Double) pop2).doubleValue()), (((Double) pop1).doubleValue())));
					else if(!(pop1 instanceof Double) && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((ValueToken) pop1).getValue()));
					newnext=null;
				}
				else if(next instanceof MultiplyOp){
					MultiplyOp newnext=new MultiplyOp();
					newnext=(MultiplyOp)next; 
					if(pop2 instanceof Double && !(pop1 instanceof Double))
						stack.push(newnext.operate((((Double) pop2).doubleValue()), ((ValueToken) pop1).getValue()));
					if(pop1 instanceof Double && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((Double) pop1).doubleValue()));
					if(pop1 instanceof Double && pop2 instanceof Double)
						stack.push(newnext.operate((((Double) pop2).doubleValue()), (((Double) pop1).doubleValue())));
					else if(!(pop1 instanceof Double) && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((ValueToken) pop1).getValue()));
					newnext=null;
				}
				else if(next instanceof DivideOp){
					DivideOp newnext=new DivideOp();
					newnext=(DivideOp)next; 
					if(pop2 instanceof Double && !(pop1 instanceof Double))
						stack.push(newnext.operate((((Double) pop2).doubleValue()), ((ValueToken) pop1).getValue()));
					if(pop1 instanceof Double && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((Double) pop1).doubleValue()));
					if(pop1 instanceof Double && pop2 instanceof Double)
						stack.push(newnext.operate((((Double) pop2).doubleValue()), (((Double) pop1).doubleValue())));
					else if(!(pop1 instanceof Double) && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((ValueToken) pop1).getValue()));
					newnext=null;
				}
				else if(next instanceof PowOp){
					PowOp newnext=new PowOp();
					newnext=(PowOp)next; 
					if(pop2 instanceof Double && !(pop1 instanceof Double))
						stack.push(newnext.operate((((Double) pop2).doubleValue()), ((ValueToken) pop1).getValue()));
					if(pop1 instanceof Double && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((Double) pop1).doubleValue()));
					if(pop1 instanceof Double && pop2 instanceof Double)
						stack.push(newnext.operate((((Double) pop2).doubleValue()), (((Double) pop1).doubleValue())));
					else if(!(pop1 instanceof Double) && !(pop2 instanceof Double))
						stack.push(newnext.operate(((ValueToken) pop2).getValue(), ((ValueToken) pop1).getValue()));
					newnext=null;
				}	 
			}
			else
				stack.push(next);
		}
	}@Override
	public double getCurrentResult(){
		return (double)stack.pop();
	}


}
