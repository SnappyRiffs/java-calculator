import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyController {
    private MyModel model;
    private MyView view;
    private boolean lastActionWasEqual = false;

    public MyController(MyModel model, MyView view) {
        this.model = model;
        this.view = view;
        init();
    }

    private void init() {
        // --- Number buttons 0-9 ---
        addNumberListener("0", view.zero);
        addNumberListener("1", view.one);
        addNumberListener("2", view.two);
        addNumberListener("3", view.three);
        addNumberListener("4", view.four);
        addNumberListener("5", view.five);
        addNumberListener("6", view.six);
        addNumberListener("7", view.seven);
        addNumberListener("8", view.eight);
        addNumberListener("9", view.nine);

        // --- Decimal point ---
        view.dot.addActionListener(e -> {
            if (lastActionWasEqual) {
                model.entryExpression = "0.";
                lastActionWasEqual = false;
            } else if (!model.entryExpression.contains(".")) {
                if (model.entryExpression.isEmpty()) model.entryExpression = "0";
                model.entryExpression += ".";
            }
            view.update();
        });

        // --- Operators ---
        addOperationListener("+", view.plus);
        addOperationListener("-", view.minus);
        addOperationListener("*", view.multiply);
        addOperationListener("/", view.divide);
        addOperationListener("%", view.mod);
        addOperationListener("^", view.pow);

        // --- Clear ---
        view.clear.addActionListener(e -> {
            model.clearExpressions();
            lastActionWasEqual = false;
            view.update();
        });

        // --- Plus/minus ---
        view.pm.addActionListener(e -> {
            if (!model.entryExpression.isEmpty() && !model.entryExpression.equals("0")) {
                if (model.entryExpression.startsWith("-")) {
                    model.entryExpression = model.entryExpression.substring(1);
                } else {
                    model.entryExpression = "-" + model.entryExpression;
                }
            }
            view.update();
        });

        // --- Equal button ---
        view.equal.addActionListener(e -> {
            if (!model.entryExpression.isEmpty()) {
                model.historyExpression += " " + model.entryExpression + "=";
            }
            model.calculate();
            lastActionWasEqual = true;
            view.update();
        });
    }

    // Helper to attach numbers
    private void addNumberListener(final String digit, javax.swing.JButton button) {
		button.addActionListener(e -> {
			if (lastActionWasEqual) {
				// Replace entry after equal, but keep history unchanged
				model.entryExpression = digit;
				lastActionWasEqual = false;
			} else if (model.entryExpression.equals("0")) {
				model.entryExpression = digit;
			} else {
				model.entryExpression += digit;
			}
			view.update();
		});
	}		

    // Helper to attach operators
    private void addOperationListener(final String operator, javax.swing.JButton button) {
		button.addActionListener(e -> {
			if (!model.entryExpression.isEmpty()) {
				// If last action was equal or a number is pressed, start new operation
				model.historyExpression = model.entryExpression + operator;
				model.entryExpression = model.entryExpression; // entry remains the number
				lastActionWasEqual = false;
				view.update();
			}
		});
	}		
}