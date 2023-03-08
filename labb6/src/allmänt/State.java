/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

import java.util.Observable;
/**
 * programmets tillstånd
 */
public class State extends Observable {
    public boolean stop;
    private double time;
    
    /**
     * skapar starttillståndet
     */
    public State() {
        stop = false;
    }

    /**
     * notifierar observatörer att något har ändrats, ändrar tiden utifrån eventet
     * @param ett event
     */
    public void notify(Event source) {
        // Spara när eventet hände
        this.setTime(source.getTime());

        this.setChanged();
        this.notifyObservers(source);
    }

    /**
     * returnerar tiden
     * @return tiden
     */
    public double getTime() {
        return time;
    }

    /**
     * sätter tiden till angiven tid
     * @param tiden
     */
    public void setTime(double time) {
        if (this.time > time) {
            throw new RuntimeException("Can not decrease time");
        }
        this.time = time;
    }
}
