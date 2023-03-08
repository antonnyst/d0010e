/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

/**
 * ett stopevent som körs i slutet av programmet för att avsluta det.
 */
public class StopEvent extends Event {
    /**
     * kallar överklassen
     * @param tillståndet
     * @param listan events
     * @param tiden
     */
    public StopEvent(State state, EventQueue queue, double time) {
        super(state, queue, time);
    }

    @Override
    public void runEvent() {
        super.runEvent();
        this.state.stop = true;
    }

    @Override
    public String toString() {
        return "Stop"; 
    }
}
