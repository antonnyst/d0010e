import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class GUI extends JFrame {
    
    JPanel canvas;
    JLabel display;
    JPanel keyPad;
    

    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.canvas = new JPanel();
        this.canvas.setLayout(new GridBagLayout());

        // Create display
        this.display = new JLabel();
        this.display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.display.setText("TEST");

        // Create keyPad



        this.keyPad = new JPanel();
        
        
        // Add components to canvas
        this.canvas.add(this.display);
        this.canvas.add(this.keyPad);




        this.setContentPane(canvas);
        
        this.pack();
        this.setVisible(true);
    }
}
