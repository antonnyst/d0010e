/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

import java.util.Observable;
import java.util.Observer;

/**
 * allmän view som inte skriver ut något, ment ska kan inplementeras av underklasser
 */
public class View implements Observer {
    protected State state;

    /**
     * ändrar instansens tillstånd till parameterns tillstånd
     * @param tillstånd
     */
    public View(State state) {
        this.state = state;
    }

    /**
     * gör inget
     */
    @Override
    public void update(Observable arg0, Object arg1) {
        // Gör inget
    }
}
