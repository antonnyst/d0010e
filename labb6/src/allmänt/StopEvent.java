/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */package allmänt;

public class StopEvent extends Event {
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
