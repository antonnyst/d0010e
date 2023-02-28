package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import snabbköp.SnabbköpState;
import snabbköp.CustomerFactory.Customer;

public class PickupEvent extends Event {
    
    private Customer customer;
    private SnabbköpState state;

    public PickupEvent(SnabbköpState state, EventQueue queue, double time, Customer customer) {
        super(state, queue, time);
        this.customer = customer;
    }

    @Override
    public void runEvent() {
        super.runEvent();

        if (this.state.getLedigaKassor() > 0) {
            // Vi betalar direkt
            this.state.decreaseLedigaKassor();

            // Skapa paymentevent för när vi betalat klart
            double paymentTime = ((SnabbköpState)this.state).getPaymentTime().finishTime(this.time);
            PaymentEvent paymentEvent = new PaymentEvent(state, queue, paymentTime);
            this.queue.insert(paymentEvent);
        } else {
            ((SnabbköpState)this.state).getKassakö().add(this.customer);
        }
    }
}
