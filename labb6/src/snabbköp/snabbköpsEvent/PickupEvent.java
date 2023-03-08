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
* Eventen för när en kund har plockat klart och går mot kassorna.
* Kollar om det finns lediga kassor och i så fall skapar ett PaymentEvent för 
* när betalningen är klar.
* Annars ställs kunden i kassakön.
*/
public class PickupEvent extends Event {
    
    private Customer customer;
    private SnabbköpState state;

    /**
     * kallar överklassen, och sparar parametrarna
     * @param tillstånd
     * @param lista med event
     * @param tiden
     * @param kund
     */
    public PickupEvent(SnabbköpState state, EventQueue queue, double time, Customer customer) {
        super(state, queue, time);
        this.customer = customer;
        this.state = state;   
    }

    /**
     * om det finns lediga kassor läggs ett payment event till i listan
     * om det inte finns lediga kassor läggs kunden till i en kö
     */
    @Override
    public void runEvent() {
        super.runEvent();

        if (this.state.getLedigaKassor() > 0) {
            // Vi betalar direkt
            this.state.decreaseLedigaKassor();

            // Skapa paymentevent för när vi betalat klart
            double paymentTime = this.state.getPaymentTime().finishTime(this.time);
            PaymentEvent paymentEvent = new PaymentEvent(state, queue, paymentTime, this.customer);
            this.queue.insert(paymentEvent);
        } else {
            // Vi måste stå i kö >:(
            this.state.getKassakö().add(this.customer);
            this.state.increaseAntalKunderKöat();
        }
    }

    @Override
    public String toString() {
        return String.format("Plock   % 6d", this.customer.id); 
    }
}
