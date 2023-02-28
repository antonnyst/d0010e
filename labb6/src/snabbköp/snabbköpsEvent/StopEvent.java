package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import allmänt.State;

public class StopEvent extends Event {
    public StopEvent(State state, EventQueue queue, double time) {
        super(state, queue, time);
    }

    @Override
    public void runEvent() {
        super.runEvent();
    }
}
