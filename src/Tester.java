
/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */
public class Tester {

	private static boolean testPassed = true;
	private static int testNum = 0;

	/**
	 * This entry function will test all classes created in this assignment.
	 * @param args command line arguments
	 */
	public static void main(String[] args) {

		// Each function here should test a different class.
		testValueToken();
		testExpTokenizer();
		testPostfixCalculator();
		testAddOp();
		testSubtractOp();
		testMultiplyOp();
		testDivideOp();
		testPowOp();
		/* TODO - write a function for each class */


		// Notifying the user that the code have passed all tests. 
		if (testPassed) {
			System.out.println("All " + testNum + " tests passed!");
		}
	}

	/**
	 * This utility function will count the number of times it was invoked. 
	 * In addition, if a test fails the function will print the error message.  
	 * @param exp The actual test condition
	 * @param msg An error message, will be printed to the screen in case the test fails.
	 */
	private static void test(boolean exp, String msg) {
		testNum++;

		if (!exp) {
			testPassed = false;
			System.out.println("Test " + testNum + " failed: "  + msg);
		}
	}

	/**
	 * Checks the ValueToken class.
	 */
	private static void testValueToken() {

		ValueToken t1 = new ValueToken(5.1);

		test(t1.getValue() == 5.1, "Value should be 5.1.");
		test(t1.toString().equals("5.1"), "Value toString should be 5.1.");


		ValueToken t2= new ValueToken(-0.7);

		test(t2.getValue() == -0.7, "Value should be -0.7");
		test(t2.toString().equals("-0.7"), "Value toString should be -0.7");

		ValueToken t3= new ValueToken(625);

		test(t3.getValue() == 625, "Value should be 625");
		test(t3.toString().equals("625.0"), "Value toString should be 625");

	}
	private static void testAddOp() {
		AddOp add = new AddOp();

		test(add.toString().equals("+"), "Value toString should be +");
		test(add.operate(3.5, 7.3) == 10.8, "Value should be 10.8");
		test(add.operate(5.2, 9.3) == 14.5, "Value should be 14.5");

	}
	private static void testSubtractOp() {

		SubtractOp sub = new SubtractOp();

		test(sub.toString().equals("-"), "Value toString should be -");
		test(sub.operate(7.4, 3.2) == 4.2, "Value should be 4.2");
		test(sub.operate(4.2, 1.1) == 3.1, "Value should be 3.1");
	}
	private static void testMultiplyOp() {

		MultiplyOp mul = new MultiplyOp();

		test(mul.toString().equals("*"), "Value toString should be -");
		test(mul.operate(7.5, 3) == 22.50, "Value should be 22.50");
		test(mul.operate(1.5, 5) == 7.50, "Value should be 7.50");
	}
	private static void testDivideOp() {

		DivideOp dev1 = new DivideOp();

		test(dev1.toString().equals("/"), "Value toString should be /");
		test(dev1.operate(7.5, 3) == 2.50, "Value should be 2.50");
		test(dev1.operate(4.5, 1.5) == 3.0, "Value should be 3.0");

		DivideOp dev2 = new DivideOp();

		test(dev2.toString().equals("/"), "Value toString should be /");
		test(dev2.operate(5, 0.4) == 12.50, "Value should be 2.50");
		test(dev2.operate(6, 0.3) == 20.0, "Value should be 20.0");

	}
	private static void testPowOp() {

		PowOp pow1 = new PowOp();

		test(pow1.toString().equals("^"), "Value toString should be ^");
		test(pow1.operate(4, 2) == 16.0, "Value should be 16.0");
		test(pow1.operate(3, 3) == 27.0, "Value should be 16.0");

		PowOp pow2 = new PowOp();

		test(pow2.toString().equals("^"), "Value toString should be ^");
		test(pow2.operate(64, 0.5) == 8.0, "Value should be 8.0");
		test(pow2.operate(16, 0.25) == 2.0, "Value should be 2.0");


	}

	/**
	 * Checks the ExpTokenizer class.
	 */
	private static void testExpTokenizer() {

		ExpTokenizer expT1=new ExpTokenizer("5 3 +");
		test(expT1.countTokens() == 3, "Value should be 3");
		expT1.setIndex(1);
		test(expT1.hasMoreElements() == true, "Value should be true");
		expT1.setIndex(2);
		test(expT1.hasMoreElements() == true, "Value should be true");
		expT1.setIndex(3);
		test(expT1.hasMoreElements() == false, "Value should be false");
		expT1.setIndex(0);
		test(expT1.nextToken().equals("5"), "Value should be 5");
		test(expT1.nextToken().equals("3"), "Value should be 3");
		test(expT1.nextToken().equals("+"), "Value should be +");

		ExpTokenizer expT2=new ExpTokenizer("2 3 + 4 2 - *");
		test(expT2.countTokens() == 7, "Value should be 7");
		expT2.setIndex(1);
		test(expT2.hasMoreElements() == true, "Value should be true");
		expT2.setIndex(2);
		test(expT2.hasMoreElements() == true, "Value should be true");
		expT2.setIndex(3);
		test(expT2.hasMoreElements() == true, "Value should be true");
		expT2.setIndex(4);
		test(expT2.hasMoreElements() == true, "Value should be true");
		expT2.setIndex(5);
		test(expT2.hasMoreElements() == true, "Value should be true");
		expT2.setIndex(6);
		test(expT2.hasMoreElements() == true, "Value should be true");
		expT2.setIndex(7);
		test(expT2.hasMoreElements() == false, "Value should be false");

		expT2.setIndex(0);
		test(expT2.nextToken().equals("2"), "Value should be 5");
		test(expT2.nextToken().equals("3"), "Value should be 3");
		test(expT2.nextToken().equals("+"), "Value should be +");
		test(expT2.nextToken().equals("4"), "Value should be +");
		test(expT2.nextToken().equals("2"), "Value should be +");
		test(expT2.nextToken().equals("-"), "Value should be +");
		test(expT2.nextToken().equals("*"), "Value should be +");
	}

	/**
	 * Checks the PostfixCalculator class.
	 */
	private static void testPostfixCalculator() {

		PostfixCalculator p1=new PostfixCalculator();
		p1.evaluate("1 2 +");
		test(p1.getCurrentResult()==3.0, "Value should be 3.0");
		p1.evaluate("3 5 -");
		test(p1.getCurrentResult()==-2.0, "Value should be -2.0");
		p1.evaluate("6 2 *");
		test(p1.getCurrentResult()==12.0, "Value should be 12.0");
		p1.evaluate("10 4 /");
		test(p1.getCurrentResult()==2.5, "Value should be 2.5");
		p1.evaluate("2 4 ^");
		test(p1.getCurrentResult()==16.0, "Value should be 16.0");
		p1.evaluate("2 3 + 4 2 - *");
		test(p1.getCurrentResult()==10.0, "Value should be 10.0");
		p1.evaluate("2 3 ^ 4 2 * / 7 -");
		test(p1.getCurrentResult()==-6.0, "Value should be -6.0");
		p1.evaluate("3 5 8 + *");
		test(p1.getCurrentResult()==39.0, "Value should be 39.0");
		p1.evaluate("8 5 3 * +");
		test(p1.getCurrentResult()==23.0, "Value should be 23.0");
		p1.evaluate("4 0.5 ^");
		test(p1.getCurrentResult()==2.0, "Value should be 2.0");
		p1.evaluate("2 5 + 3 2 - *");
		test(p1.getCurrentResult()==7.0, "Value should be 7.0");
		p1.evaluate("2 4 ^ 2 4 * / 10 -");
		test(p1.getCurrentResult()==-8.0, "Value should be -8.0");
		p1.evaluate("2 6 5 + *");
		test(p1.getCurrentResult()==22.0, "Value should be 22.0");


		//************************** Exception Catch ***********************
		try {
			p1.evaluate("4 5 $");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: invalid token $ "), "should return an exception ");
		}
		try {
			p1.evaluate("7.0.1");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: invalid number 7.0.1 "), "should return an exception");
		}

		try {
			p1.evaluate("*");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: lone operetor * "), "should return an exception");
		}
		try {
			p1.evaluate("2 5");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: cannot perform operation on the string "), "should return an exception");
		}
		try {
			p1.evaluate("* 7");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: cannot perform operation on the string "), "should return an exception");
		}
		try {
			p1.evaluate(".6");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: cannot perform operation on the string "), "should return an exception");
		}
		try {
			p1.evaluate("*-4");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: cannot perform operation on the string "), "should return an exception");
		}
		try {
			p1.evaluate("#3");
		}
		catch (ParseException e) {
			test(e.getMessage().equals("SYNTAX ERROR: invalid token #3 "), "should return an exception");
		}




	}



}