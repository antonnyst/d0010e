/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import snabbköp.SnabbköpState;
import snabbköp.CustomerFactory.Customer;

/**
* Eventen för när en kund har betalat klart. 
* Minskar antalet kunder i butiken samt antalet som har handlat.
* Kollar dessutom om det finns kunder i kassakön och i så fall skapar ett nytt PaymentEvent
* för nästa kund som betalar.
*/
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
    }   
    
    @Override
    public String toString() {
        return String.format("Betalning % 4d", this.customer.id); 
    }
}
