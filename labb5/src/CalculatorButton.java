import javax.swing.JButton;

public abstract class CalculatorButton extends JButton {
    public CalculatorButton(String label, Situation situation) {
        super(label);
    }

    public abstract void transition(Situation situation);
}
