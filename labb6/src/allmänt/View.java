/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    protected State state;

    public View(State state) {
        this.state = state;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // Gör inget
    }
}
