/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

/**
 * Den skapar en Event och notifierar State när eventet exekveras.
 */

public class Event {
    protected State state;
    protected EventQueue queue;
    protected double time;

    // den skapar eventet
    public Event(State state, EventQueue queue, double time) {
        this.state = state;
        this.queue = queue;
        this.time = time;
    }

    // notifierar staten
    public void runEvent() {
        this.state.notify(this);
    }

    // returnerar tiden när det hände
    public double getTime() {
        return time;
    }
}
