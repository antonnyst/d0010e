// Anton Nystrom Malcolm Ovin
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.util.function.IntBinaryOperator;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class GUI extends JFrame {
    
    JPanel canvas;
    JLabel display;
    JPanel keyPad;
    

    public GUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create canvas
        this.canvas = new JPanel();
        this.canvas.setPreferredSize(new Dimension(500,500));
        this.canvas.setLayout(new GridBagLayout());
        this.setContentPane(canvas);

        // Create display
        this.display = new JLabel();
        this.display.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.display.setText("0");
        this.display.setFont(new Font(this.display.getFont().getFontName(), Font.PLAIN, 40));
        this.display.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add display
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.gridx = 0;
        constraints.gridy = 0;
        this.canvas.add(this.display, constraints);

        // Create keyPad
        this.keyPad = new JPanel();
        this.keyPad.setLayout(new GridLayout(4,4));

        // Add keypad 
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.weighty = 9;
        constraints.gridx = 0;
        constraints.gridy = 1;
        this.canvas.add(this.keyPad, constraints);


        // Create buttons
        Situation situation = new Situation(this.display);

        this.keyPad.add(new DigitButton("7", situation));
        this.keyPad.add(new DigitButton("8", situation));
        this.keyPad.add(new DigitButton("9", situation));
        this.keyPad.add(new BinOpButton("/", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int arg0, int arg1) {
                return arg0 / arg1;
            }
        }));
        this.keyPad.add(new DigitButton("4", situation));
        this.keyPad.add(new DigitButton("5", situation));
        this.keyPad.add(new DigitButton("6", situation));
        this.keyPad.add(new BinOpButton("*", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int arg0, int arg1) {
                return arg0 * arg1;
            }
        }));
        this.keyPad.add(new DigitButton("1", situation));
        this.keyPad.add(new DigitButton("2", situation));
        this.keyPad.add(new DigitButton("3", situation));
        this.keyPad.add(new BinOpButton("-", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int arg0, int arg1) {
                return arg0 - arg1;
            }
        }));
        this.keyPad.add(new DigitButton("0", situation));
        this.keyPad.add(new EqualsButton("=", situation));
        this.keyPad.add(new CancelButton("C", situation));
        this.keyPad.add(new BinOpButton("+", situation, new IntBinaryOperator() {
            @Override
            public int applyAsInt(int arg0, int arg1) {
                return arg0 + arg1;
            }
        }));        

        this.pack();
        this.setVisible(true);
    }
}
