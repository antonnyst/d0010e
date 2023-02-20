import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.*;

public abstract class CalculatorButton extends JButton {
    Situation situation;
    String label;
    //Color färg;
    
    public CalculatorButton(String label, Situation situation) {
        super(label);
        this.label = label;
        this.situation = situation;

        this.setFont(new Font(this.getFont().getFontName(), Font.PLAIN, 40));

        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                transition();                
            }
        });
    }

    public abstract void transition();

    public abstract void setColor();

    @Override
    public String toString(){
        return label;
    }


}
