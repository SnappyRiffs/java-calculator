public class MyModel {
    public String historyExpression = "";   // History panel
    public String entryExpression = "";     // Entry panel

    private double leftOperand = 0;         // Stored left operand
    private String operator = "";           // Stored operator
    private double lastRightOperand = 0;   // Last right operand (for repeated =)
    public boolean justCalculated = false; // Flag if last action was equal
	public boolean newEntry = false; // true when the next number should start a new entry

    public void clearExpressions() {
        historyExpression = "";
        entryExpression = "";
        leftOperand = 0;
        operator = "";
        lastRightOperand = 0;
        justCalculated = false;
    }

    public void setOperator(String op) {
		if (!entryExpression.isEmpty()) {
			leftOperand = Double.parseDouble(entryExpression);
		}
		operator = op;
		historyExpression = entryExpression + " " + operator + " ";
		newEntry = true;  // next number replaces entry
		justCalculated = false;
	}	

    public void inputNumber(String number) {
        if (justCalculated || newEntry) {
            // After equal, new number replaces entry
            entryExpression = number;
            justCalculated = false;
        } else {
            entryExpression += number;
        }
    }

    public void calculate() {
		try {
			double rightOperand;
	
			// If entry is empty or invalid, use last right operand
			if (justCalculated) {
				rightOperand = lastRightOperand;
			} else if (entryExpression.isEmpty()) {
				rightOperand = leftOperand; // use left as right if nothing entered
				lastRightOperand = rightOperand;
			} else {
				rightOperand = Double.parseDouble(entryExpression);
				lastRightOperand = rightOperand;
			}
	
			double result = 0;
	
			switch (operator) {
				case "+": result = leftOperand + rightOperand; break;
				case "-": result = leftOperand - rightOperand; break;
				case "*": result = leftOperand * rightOperand; break;
				case "/":
					if (rightOperand == 0) {
						entryExpression = "Can't divide by zero";
						historyExpression = leftOperand + " / 0 =";
						justCalculated = true;
						newEntry = true;
						return;
					}
					result = leftOperand / rightOperand;
					break;
				case "%":
					if (rightOperand == 0) {
						entryExpression = "Can't divide by zero";
						historyExpression = leftOperand + " % 0 =";
						justCalculated = true;
						newEntry = true;
						return;
					}
					result = leftOperand % rightOperand;
					break;
				case "^": result = Math.pow(leftOperand, rightOperand); break;
				default: result = rightOperand; break;
			}
	
			historyExpression = leftOperand + " " + operator + " " + rightOperand + " =";
			entryExpression = String.valueOf(result);
	
			leftOperand = result;
			justCalculated = true;
			newEntry = true;
	
		} catch (NumberFormatException e) {
			entryExpression = "ERROR";
		}
	}
	// TODO: fix 0.0 n.0 =	
}
