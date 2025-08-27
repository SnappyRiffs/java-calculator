import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyController {
	private MyModel model;
	private MyView view;

	public MyController(MyModel model, MyView view) {
		this.model = model;
		this.view = view;
		init(this.model, this.view);
	}

	private void init(MyModel model, MyView view) {

		// Listeners for operations
		// everything but clear sets history expression to the current entry
		this.view.clear.addActionListener(new ActionListener() { // creates a Listener to the JButton clear which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				model.clearExpressions();
				view.update();
			}
		});

		this.view.plus.addActionListener(new ActionListener() { // creates a Listener to the JButton plus which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!model.entryExpression.isEmpty()) {
					model.historyExpression += " " + model.entryExpression;
				}
				model.entryExpression = "+";
				view.update();
			}
		});

		this.view.minus.addActionListener(new ActionListener() { // creates a Listener to the JButton minus which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!model.entryExpression.isEmpty()) {
					model.historyExpression += " " + model.entryExpression;
				}
				model.entryExpression = "-";
				view.update();
			}
		});

		this.view.multiply.addActionListener(new ActionListener() { // creates a Listener to the JButton x which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!model.entryExpression.isEmpty()) {
					model.historyExpression += " " + model.entryExpression;
				}
				model.entryExpression = "*"; // can also be model.entryExpression = "x";
				view.update();
			}
		});

		this.view.divide.addActionListener(new ActionListener() { // creates a Listener to the JButton / which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!model.entryExpression.isEmpty()) {
					model.historyExpression += " " + model.entryExpression;
				}
				model.entryExpression = "/"; // can also be model.entryExpression = "DIV";
				view.update();
			}
		});

		this.view.mod.addActionListener(new ActionListener() { // creates a Listener to the JButton % which is declared
																// in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!model.entryExpression.isEmpty()) {
					model.historyExpression += " " + model.entryExpression;
				}
				model.entryExpression = "%"; // can also be model.entryExpression = "MOD";
				view.update();
			}
		});

		this.view.pow.addActionListener(new ActionListener() { // creates a Listener to the JButton pow which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (!model.entryExpression.isEmpty()) {
					model.historyExpression += " " + model.entryExpression;
				}
				model.entryExpression = "^"; // can also be model.entryExpression = "pow";
				view.update();
			}
		});

		// Listeners for numbers
		this.view.zero.addActionListener(new ActionListener() { // creates a Listener to the JButton 0 which is declared
																// in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "0";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "0";
				}
				view.update();

			}
		});

		this.view.one.addActionListener(new ActionListener() { // creates a Listener to the JButton 1 which is declared
																// in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "1";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "1";
				}
				view.update();
			}
		});

		this.view.two.addActionListener(new ActionListener() { // creates a Listener to the JButton 2 which is declared
																// in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "2";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "2";
				}
				view.update();
			}
		});

		this.view.three.addActionListener(new ActionListener() { // creates a Listener to the JButton 3 which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "3";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "3";
				}
				view.update();
			}
		});

		this.view.four.addActionListener(new ActionListener() { // creates a Listener to the JButton 4 which is declared
																// in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "4";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "4";
				}
				view.update();
			}
		});

		this.view.five.addActionListener(new ActionListener() { // creates a Listener to the JButton five which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "5";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "5";
				}
				view.update();
			}
		});

		this.view.six.addActionListener(new ActionListener() { // creates a Listener to the JButton six which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "6";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "6";
				}
				view.update();
			}
		});

		this.view.seven.addActionListener(new ActionListener() { // creates a Listener to the JButton seven which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "7";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "7";
				}
				view.update();

			}
		});

		this.view.eight.addActionListener(new ActionListener() { // creates a Listener to the JButton eight which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "8";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "8";
				}
				view.update();

			}
		});

		this.view.nine.addActionListener(new ActionListener() { // creates a Listener to the JButton nine which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()
						|| model.entryExpression.charAt(model.entryExpression.length() - 1) == '.'
						|| (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
								&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += "9";
				} else {
					model.historyExpression += " " + model.entryExpression;
					model.entryExpression = "9";
				}
				view.update();
			}
		});

		// Listeners for symbols
		this.view.pm.addActionListener(new ActionListener() { // creates a Listener to the JButton sign which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()) {
					model.entryExpression = "ERROR";
				}
				if (model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
						&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9') {
					model.entryExpression = String.valueOf(Integer.parseInt(model.entryExpression) * (-1));
				} else {
					model.entryExpression = "ERROR";
				}
				view.update();
			}
		});

		this.view.dot.addActionListener(new ActionListener() { // creates a Listener to the JButton dot which is
																// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				if (model.entryExpression.isEmpty()) {
					model.entryExpression += "0";
				}
				if ((model.entryExpression.charAt(model.entryExpression.length() - 1) >= '0'
						&& model.entryExpression.charAt(model.entryExpression.length() - 1) <= '9')) {
					model.entryExpression += ".";
				}
				view.update();
			}
		});

		this.view.equal.addActionListener(new ActionListener() { // creates a Listener to the JButton equal which is
																	// declared in MyView.java
			@Override
			public void actionPerformed(ActionEvent event) {
				try {
					if (!model.entryExpression.isEmpty()) {
						model.historyExpression += " " + model.entryExpression;
					}
					model.entryExpression = "=";
					model.calculate();
					view.update();
					model.entryExpression = "";
					view.update(); // how have I not added this before :D
				} catch (Exception er) {
					System.out.println("Error!");
				}

			}
		});
	}
}
