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

/**
 * CloseStoreEvent stänger butiken genom att använda setter metoden i
 * SnabbköpsState.
 */
public class CloseStoreEvent extends Event {
    SnabbköpState state;

    /**
     * skapar en CloseStoreEvent med överklassenskonstruktor
     * @param tillstånd
     * @param lista med event
     * @param tiden
     */
    public CloseStoreEvent(SnabbköpState state, EventQueue queue, double time) {
        super(state, queue, time);
        this.state = state;
    }

    /**
     * kallar överklassen och sätter shopOpen parametern till false
     */
    @Override
    public void runEvent() {
        super.runEvent();

        // Sätt shopOpen till false
        this.state.setShopStatus(false);
    }

    @Override
    public String toString() {
        return "Stänger    ---";
    }
}
