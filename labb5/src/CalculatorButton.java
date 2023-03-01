// Anton Nystrom Malcolm Ovin
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public abstract class CalculatorButton extends JButton {
    static final Color DEFAULT_COLOR = Color.WHITE;
    static final Color HIGHLIGHT_COLOR = Color.RED;

    Situation situation;
    String label;
    
    public CalculatorButton(String label, Situation situation) {
        super(label);
        this.label = label;
        this.situation = situation;

        this.setFont(new Font(this.getFont().getFontName(), Font.PLAIN, 40));
        this.setColor(DEFAULT_COLOR);
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                transition();                
            }
        });
    }

    public abstract void transition();

    public void setColor(Color color) {
        this.setBackground(color);
    }

    @Override
    public String toString(){
        return label;
    }
}
