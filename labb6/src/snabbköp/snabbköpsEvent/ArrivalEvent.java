package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import snabbköp.SnabbköpState;
import snabbköp.CustomerFactory.Customer;

public class ArrivalEvent extends Event {

    private Customer customer;
    private SnabbköpState state;

    public ArrivalEvent(SnabbköpState state, EventQueue queue, double time, Customer customer) {
        super(state, queue, time);
        this.customer = customer;
        this.state = state;   
    }

    @Override
    public void runEvent() {
        super.runEvent();

        if (this.state.getShopOpen()) {
            // Butiken är öppen
            
            // Lägg till nästa arrival
            double arrivalTime = this.state.getArrivalTime().finishTime(time);
            ArrivalEvent arrivalEvent = new ArrivalEvent(
                state,
                queue,
                arrivalTime,
                this.state.getCustomerFactory().getCustomer()
                );
            this.queue.insert(arrivalEvent);

            if (this.state.getAntalKunder() < this.state.getMaxAntalKunder()) {
                // Det finns plats i butiken :)
                
                // Gå in i den då
                this.state.increaseAntalKunder();
                
                // Lägg till pickupevent för när vi plockat klart
                double pickupTime = this.state.getPickupTime().finishTime(time);
                PickupEvent pickupEvent = new PickupEvent(
                    this.state,
                    this.queue,
                    pickupTime,
                    this.customer
                );
                this.queue.insert(pickupEvent);
            } else {
                // Missad kund
                ((SnabbköpState)this.state).increaseKunderMissat();
            }
        } else {
            // Butiken är stängd :(
        }
    }
}
