
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculatorUI ui = new CalculatorUI();
            ui.setVisible(true);
        });
    }
}
