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
        
        // Beräkna tid
        double tid = ((SnabbköpState)this.state).getArrivalTime().finishTime(this.time);

        // Skapa event och lägg i eventqueue
        this.queue.insert(new ArrivalEvent((SnabbköpState)this.state, this.queue, tid));
    }
}
