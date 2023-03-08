/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package snabbköp.snabbköpsEvent;

import allmänt.EventQueue;
import allmänt.StartEvent;
import snabbköp.SnabbköpState;

/**
* Startar snabbköpssimuleringen genom att skapa det första ArrivalEventet.
*/
public class SnabbköpStartEvent extends StartEvent {
    
    private SnabbköpState state;

    /**
    * Konstruktor för SnabbköpStartEvent.
    * @param state State för simuleringen
    * @param queue EventQueuen för simuleringen
    */
    public SnabbköpStartEvent(SnabbköpState state, EventQueue queue) {
        super(state, queue);
        this.state = state;   
    }

    /**
    * Kör eventet.
    * Skapar det första ArrivalEventet.
    */
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
