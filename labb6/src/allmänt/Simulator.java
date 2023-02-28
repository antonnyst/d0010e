package allmänt;

public class Simulator {
    State state;
    EventQueue queue;

    public Simulator(State state, EventQueue queue) {
        this.state = state;
        this.queue = queue;
    }

    public void run() {
        while (state.stop == false && queue.content.size() > 0) {
            Event nextEvent = queue.next();
            nextEvent.runEvent();
        }
    }
}
