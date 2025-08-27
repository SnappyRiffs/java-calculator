import java.util.Arrays;

public class MyModel {
	public String historyExpression; // This gets updated everytime a button is pressed and is printed in the history
										// panel
	public String entryExpression; // This gets updated everytime a button is pressed and is printed in the entry panel
	
	public MyModel() {
		clearExpressions();
	}

	public void clearExpressions() {
		historyExpression = "";
		entryExpression = "";
	}

	public void calculate() {
		String[] expression = historyExpression.trim().split(" "); // takes the result of historyExpression calculated
																	// from MyController.java and converts it into an
																	// array
		System.out.println(Arrays.toString(expression));
		double firstNumber = Double.parseDouble(expression[0]);
		String operation = expression[1];
		double secondNumber = Double.parseDouble(expression[2]);
		double result = 0;
		if (operation.equals("+")) {
			result = firstNumber + secondNumber;
		} else if (operation.equals("-")) {
			result = firstNumber - secondNumber;
		} else if (operation.equals("*") || operation.equals("x")) {
			result = firstNumber * secondNumber;
		} else if (operation.equals("/") || operation.equals("DIV")) {
			result = firstNumber / secondNumber;
		} else if (operation.equals("%") || operation.equals("MOD")) {
			result = firstNumber % secondNumber;
		} else if (operation.equals("pow") || operation.equals("^")) {
			result = Math.pow(firstNumber, secondNumber);
		}

		historyExpression = String.valueOf(result);
		for (String exp : expression) {
			System.out.print(exp);
			System.out.print(" ");
		}
		System.out.println("= " + historyExpression + "\t");

	}
}
