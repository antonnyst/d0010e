package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import allmänt.State;
import snabbköp.PaymentTime;
import snabbköp.SnabbköpState;
import snabbköp.CustomerFactory.Customer;

public class PaymentEvent extends Event {

    private Customer customer;
    private SnabbköpState state;

    public PaymentEvent(SnabbköpState state, EventQueue queue, double time, Customer customer) {
        super(state, queue, time);
        this.customer = customer;
        this.state = state;
    }

    @Override
    public void runEvent() {
        super.runEvent();

        // minska antalet kunder i snabbköp, öka antalet kunder som har handlat

        this.state.decreaseAntalKunder();
        this.state.increaseAntalKunderHandlat();
        

        if (this.state.getKassakö().hasNext()){
            Customer c = this.state.getKassakö().next();
            double paymentTime = this.state.getPaymentTime().finishTime(this.time);
            PaymentEvent paymentEvent = new PaymentEvent(state, queue, paymentTime, c);
            this.queue.insert(paymentEvent);
        }
        else{
            this.state.increaseLedigaKassor();
        }




        this.state.increaseLedigaKassor();

        





    }

    
}
