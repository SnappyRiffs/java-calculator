public class MyModel {
    public String historyExpression = "";   // History panel
    public String entryExpression = "";     // Entry panel
    public String lastOperator = "";        // Last operator pressed
    public double lastOperand = 0;          // Last operand used
    public double lastResult = 0;           // Last calculated result

    public void clearExpressions() {
        historyExpression = "";
        entryExpression = "";
        lastOperator = "";
        lastOperand = 0;
        lastResult = 0;
    }

    // Helper method to compute an operation
    private double compute(double left, String op, double right) {
        switch (op) {
            case "+": return left + right;
            case "-": return left - right;
            case "*": return left * right;
            case "/": return left / right;
            case "%": return left % right;
            case "^": return Math.pow(left, right);
        }
        return right;
    }

    // Main calculation method
    public void calculate() {
        try {
            double currentNumber = entryExpression.isEmpty() ? 0 : Double.parseDouble(entryExpression);

            if (!lastOperator.isEmpty() && historyExpression.endsWith("=")) {
                // Repeat last operation (Rule 2)
                lastResult = compute(lastResult, lastOperator, lastOperand);
                entryExpression = String.valueOf(lastResult);
                historyExpression += lastOperator + lastOperand + "=";
                return;
            }

            String[] tokens = historyExpression.trim().split(" ");
            if (tokens.length >= 2) {
                double left = Double.parseDouble(tokens[tokens.length - 2]);
                String op = tokens[tokens.length - 1];

                lastOperator = op;
                lastOperand = currentNumber;
                lastResult = compute(left, op, currentNumber);

                entryExpression = String.valueOf(lastResult);
            } else {
                // Single number, just store it as lastResult
                lastResult = currentNumber;
            }
        } catch (Exception e) {
            entryExpression = "ERROR";
        }
    }
}
