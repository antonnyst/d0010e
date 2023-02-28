package allmänt;

import java.util.Observable;
import java.util.Observer;

public class View implements Observer {
    State state;

    public View(State state) {
        this.state = state;
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // Gör inget
    }
}
