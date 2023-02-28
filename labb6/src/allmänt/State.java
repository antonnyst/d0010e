package allmänt;

import java.util.Observable;

public class State extends Observable {
    public boolean stop;

    public State() {
        stop = false;
    }

    public void notify(Event source) {
        this.setChanged();
        this.notifyObservers(source);
    }
}
