import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class CalculatorButton extends JButton {
    Situation situation;
    
    public CalculatorButton(String label, Situation situation) {
        super(label);
        this.situation = situation;

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                transition();                
            }
        });
    }

    public abstract void transition();
}
