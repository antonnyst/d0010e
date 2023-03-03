package snabbköp.snabbköpsEvent;

import allmänt.EventQueue;
import allmänt.StartEvent;
import snabbköp.SnabbköpState;

public class SnabbköpStartEvent extends StartEvent {
    
    private SnabbköpState state;

    public SnabbköpStartEvent(SnabbköpState state, EventQueue queue) {
        super(state, queue);
        this.state = state;   
    }

    @Override
    public void runEvent() {
        super.runEvent();
        // Lägg till första arrival event
        
        // Beräkna tid
        double tid = this.state.getArrivalTime().finishTime(this.time);

        // Skapa event och lägg i eventqueue
        this.queue.insert(
            new ArrivalEvent(
                this.state,
                this.queue,
                tid,
                this.state.getCustomerFactory().getCustomer()
            )
        );
    }

    @Override
    public String toString() {
        return String.format("Start"); 
    }
}
