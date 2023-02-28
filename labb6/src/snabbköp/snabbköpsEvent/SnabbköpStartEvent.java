package snabbköp.snabbköpsEvent;

import allmänt.EventQueue;
import allmänt.StartEvent;
import snabbköp.SnabbköpState;

public class SnabbköpStartEvent extends StartEvent {
    public SnabbköpStartEvent(SnabbköpState state, EventQueue queue) {
        super(state, queue);
    }

    @Override
    public void runEvent() {
        super.runEvent();
        // Lägg till första arrival event
        
        double tid = ((SnabbköpState)this.state).getArrivalTime().finishTime(this.time);

        this.queue.insert(new ArrivalEvent(this.state, this.queue, tid));
    }
}
