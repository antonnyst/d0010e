package allmänt;

public class Event {
    
    private State state;
    private EventQueue queue;
    private double time;

    public Event(State state, EventQueue queue, double time) {
        this.state = state;
        this.queue = queue;
        this.time = time;
    }

    public void runEvent() {
        this.state.notify(this);
    }

    public double getTime() {
        return time;
    }
}
