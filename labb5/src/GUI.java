import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.GridBagLayout;  

public class GUI extends JFrame {
    
    JPanel canvas;

    public GUI() {
        this.canvas = new JPanel();
        this.setContentPane(canvas);
        
        this.canvas.setLayout(new GridBagLayout());
        
        this.pack();
        this.setVisible(true);
    }
}
