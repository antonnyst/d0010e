package snabbköp.snabbköpsEvent;

import allmänt.Event;
import allmänt.EventQueue;
import snabbköp.SnabbköpState;

public class ArrivalEvent extends Event {
    public ArrivalEvent(SnabbköpState state, EventQueue queue, double time) {
        super(state, queue, time);
    }

    @Override
    public void runEvent() {
        super.runEvent();

        if (((SnabbköpState)this.state).getShopOpen()) {
            // Butiken är öppen
            
            // Lägg till nästa arrival
            double arrivalTime = ((SnabbköpState)this.state).getArrivalTime().finishTime(time);
            PickupEvent arrivalEvent = new PickupEvent(state, queue, arrivalTime);
            this.queue.insert(arrivalEvent);

            if (((SnabbköpState)this.state).getAntalKunder() < ((SnabbköpState)this.state).getMaxAntalKunder()) {
                // Det finns plats i butiken :)
                
                // Gå in i den då
                ((SnabbköpState)this.state).increaseAntalKunder();
                
                // Lägg till pickupevent för när vi plockat klart
                double pickupTime = ((SnabbköpState)this.state).getPickupTime().finishTime(time);
                PickupEvent pickupEvent = new PickupEvent(state, queue, pickupTime);
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
