import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MyView {
	private MyModel model;

	public JLabel historyView;
	public JLabel entryView;

	public JButton plus;
	public JButton minus;
	public JButton multiply;
	public JButton divide;
	public JButton mod;
	public JButton pow;
	public JButton pm;
	public JButton dot;
	public JButton equal;
	public JButton zero;
	public JButton one;
	public JButton two;
	public JButton three;
	public JButton four;
	public JButton five;
	public JButton six;
	public JButton seven;
	public JButton eight;
	public JButton nine;
	public JButton clear;

	public MyView(MyModel model) {
		this.model = model;
		this.historyView = new JLabel("", SwingConstants.RIGHT);
		this.entryView = new JLabel("", SwingConstants.RIGHT);
		init();
	}

	// This method is called from the controller whenever there is a new entry
	public void update() {
		historyView.setText(this.model.historyExpression);
		entryView.setText(this.model.entryExpression);
	}

	JPanel mainPanel;
	JPanel historyPanel;
	JPanel entryPanel;
	JPanel buttonPanel;

	public void init() {
		JFrame frame = new JFrame("My Calculator");
		frame.setBackground(Color.WHITE);
		frame.setSize(new Dimension(330, 1000));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		mainPanel = new JPanel();
		mainPanel.setVisible(true);
		mainPanel.setPreferredSize(new Dimension(330, 600));
		mainPanel.setBackground(Color.WHITE);

		historyPanel = new JPanel();
		historyPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		historyPanel.setVisible(true);
		historyPanel.setPreferredSize(new Dimension(296, 50));
		historyPanel.setBackground(Color.WHITE);
		historyPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
		setHistoryPanel(this.historyPanel);

		entryPanel = new JPanel();
		entryPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		entryPanel.setVisible(true);
		entryPanel.setPreferredSize(new Dimension(296, 150));
		entryPanel.setBackground(Color.WHITE);
		entryPanel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 5));
		setEntryPanel(this.entryPanel);

		buttonPanel = new JPanel();
		buttonPanel.setVisible(true);
		buttonPanel.setPreferredSize(new Dimension(330, 400));
		buttonPanel.setBackground(Color.WHITE);
		setButtonPanel(this.buttonPanel);

		mainPanel.add(this.historyPanel);
		mainPanel.add(this.entryPanel);
		mainPanel.add(this.buttonPanel);

		frame.add(this.mainPanel);
		frame.pack();
	}

	Font defaultFont = new Font(Font.DIALOG, Font.PLAIN, 20);

	private void setHistoryPanel(JPanel historyPanel) {
		historyView.setVisible(true);
		historyView.setFont(defaultFont);
		historyPanel.add(historyView);
	}

	private void setEntryPanel(JPanel entryPanel) {
		entryView.setVisible(true);
		entryView.setFont(defaultFont);
		entryPanel.add(entryView);
	}

	Dimension dimensions = new Dimension(310, 70);

	private void setButtonPanel(JPanel buttonPanel) {

		// row1
		JPanel row1 = new JPanel();
		row1.setBackground(Color.WHITE);
		row1.setVisible(true);
		row1.setPreferredSize(dimensions);

		plus = new JButton();
		configButton(plus, defaultFont, "+");

		minus = new JButton();
		configButton(minus, defaultFont, "-");

		multiply = new JButton();
		configButton(multiply, defaultFont, "*");

		divide = new JButton();
		configButton(divide, defaultFont, "/");

		row1.add(plus);
		row1.add(minus);
		row1.add(multiply);
		row1.add(divide);

		// row2
		JPanel row2 = new JPanel();
		row2.setBackground(Color.WHITE);
		row2.setVisible(true);
		row2.setPreferredSize(dimensions);
		seven = new JButton();
		configButton(seven, defaultFont, "7");
		eight = new JButton();
		configButton(eight, defaultFont, "8");
		nine = new JButton();
		configButton(nine, defaultFont, "9");
		mod = new JButton();
		configButton(mod, defaultFont, "%");
		row2.add(seven);
		row2.add(eight);
		row2.add(nine);
		row2.add(mod);

		// row3
		JPanel row3 = new JPanel();
		row3.setBackground(Color.WHITE);
		row3.setVisible(true);
		row3.setPreferredSize(dimensions);
		four = new JButton();
		configButton(four, defaultFont, "4");
		five = new JButton();
		configButton(five, defaultFont, "5");
		six = new JButton();
		configButton(six, defaultFont, "6");
		pow = new JButton();
		configButton(pow, defaultFont, "^");
		row3.add(four);
		row3.add(five);
		row3.add(six);
		row3.add(pow);

		// row4
		JPanel row4 = new JPanel();
		row4.setBackground(Color.WHITE);
		row4.setVisible(true);
		row4.setPreferredSize(dimensions);
		one = new JButton();
		configButton(one, defaultFont, "1");
		two = new JButton();
		configButton(two, defaultFont, "2");
		three = new JButton();
		configButton(three, defaultFont, "3");
		clear = new JButton();
		configButton(clear, defaultFont, "C");
		row4.add(one);
		row4.add(two);
		row4.add(three);
		row4.add(clear);

		// row5
		JPanel row5 = new JPanel();
		row5.setBackground(Color.WHITE);
		row5.setVisible(true);
		row5.setPreferredSize(dimensions);
		pm = new JButton();
		configButton(pm, defaultFont, "+/-");
		zero = new JButton();
		configButton(zero, defaultFont, "0");
		dot = new JButton();
		configButton(dot, defaultFont, ".");
		equal = new JButton();
		configButton(equal, defaultFont, "=");
		row5.add(pm);
		row5.add(zero);
		row5.add(dot);
		row5.add(equal);

		buttonPanel.add(row1);
		buttonPanel.add(row2);
		buttonPanel.add(row3);
		buttonPanel.add(row4);
		buttonPanel.add(row5);
	}

	private void configButton(JButton button, Font defaultFont, String text) {
		button.setPreferredSize(new Dimension(70, 60));
		button.setVisible(true);
		button.setText(text);
		button.setFont(defaultFont);
		button.setMargin(new Insets(0, 0, 0, 0));
	}
}
