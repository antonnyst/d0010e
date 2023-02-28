package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import snabbköp.SnabbköpState;

public class CloseStoreEvent extends Event {
    public CloseStoreEvent(SnabbköpState state, EventQueue queue, double time) {
        super(state, queue, time);
    }

    @Override
    public void runEvent() {
        super.runEvent();

        // Sätt shopOpen till false
        ((SnabbköpState)this.state).setShopStatus(false);
    }
}
