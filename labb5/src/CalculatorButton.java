import javax.swing.JButton;

public abstract class CalculatorButton extends JButton {
    Situation situation;
    
    public CalculatorButton(String label, Situation situation) {
        super(label);
        this.situation = situation;
    }

    public abstract void transition();
}
