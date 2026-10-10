import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {

    private final JTextField expressionField;
    private final JLabel resultLabel;

    public CalculatorUI() {
        setTitle("Expression Calculator");
        setSize(450, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(0, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel title = new JLabel("Expression Calculator");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        expressionField = new JTextField();
        expressionField.setFont(new Font("Arial", Font.PLAIN, 18));
        expressionField.setToolTipText("Example: 3 * 2 + (8 - 3)");

        JButton calculateButton = new JButton("Calculate");
        JButton clearButton = new JButton("Clear");

        resultLabel = new JLabel("Result: ");
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));

        calculateButton.addActionListener(e -> calculate());
        expressionField.addActionListener(e -> calculate());

        clearButton.addActionListener(e -> {
            expressionField.setText("");
            resultLabel.setText("Result: ");
        });

        panel.add(title);
        panel.add(new JLabel("Enter expression:"));
        panel.add(expressionField);

        JPanel buttons = new JPanel(new GridLayout(1, 2, 10, 0));
        buttons.add(calculateButton);
        buttons.add(clearButton);

        panel.add(buttons);
        panel.add(resultLabel);

        add(panel);
    }

    private void calculate() {
        String expression = expressionField.getText().trim();

        if (expression.isEmpty()) {
            resultLabel.setText("Enter an expression");
            return;
        }

        if (!CheckParenthesis.checkParentheses(expression)) {
            resultLabel.setText("Error: Unbalanced parentheses");
            return;
        }

        try {
            ParseNumber.NumberResult result =
                    Evaluator.evaluator(expression, 0);

            int pos = SkipSpaces.skipSpaces(expression, result.pos);

            if (pos != expression.length()) {
                throw new IllegalArgumentException(
                        "Unexpected character at position " + pos);
            }

            resultLabel.setText("Result: " + result.number);

        } catch (RuntimeException ex) {
            resultLabel.setText("Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorUI ui = new CalculatorUI();
            ui.setVisible(true);
        });
    }
}
