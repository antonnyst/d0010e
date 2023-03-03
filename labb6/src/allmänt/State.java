/** Ovin Malcolm, Nyström Anton, Gista Nikolaos, Souza Delfino Clara */
package allmänt;

import java.util.Observable;

public class State extends Observable {
    public boolean stop;
    private double time;

    public State() {
        stop = false;
    }

    public void notify(Event source) {
        // Spara när eventet hände
        this.setTime(source.getTime());

        this.setChanged();
        this.notifyObservers(source);
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        if (this.time > time) {
            throw new RuntimeException("Can not decrease time");
        }
        this.time = time;
    }
}
