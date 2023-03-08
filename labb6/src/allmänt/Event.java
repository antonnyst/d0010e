/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

/**
 * Event ett genellt event som håller koll på did och notifierar observers
 */
public class Event {
    protected State state;
    protected EventQueue queue;
    protected double time;

    /**
     * sparar de tre variablerna
     * @param state
     * @param queue
     * @param time
     */
    public Event(State state, EventQueue queue, double time) {
        this.state = state;
        this.queue = queue;
        this.time = time;
    }

    /**
     * notifierar oberservatörerna med klassinstansen som parameter
     */
    public void runEvent() {
        this.state.notify(this);
    }

    /**
     * returnerar tiden
     * @return tiden
     */
    public double getTime() {
        return time;
    }
}
