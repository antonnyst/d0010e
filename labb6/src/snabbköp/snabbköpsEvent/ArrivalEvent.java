package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import allmänt.State;

public class ArrivalEvent extends Event {
    public ArrivalEvent(State state, EventQueue queue, double time) {
        super(state, queue, time);
    }

    @Override
    public void runEvent() {
        super.runEvent();
    }
}
