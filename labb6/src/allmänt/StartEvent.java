/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

/**
 * Eventet som ska vara förs i simulationen
 */
public class StartEvent extends Event {
    /**
     * använder överklassens metod och skickar med tid 0 
     * @param programmets tillstånd
     * @param listan med event
     */
    public StartEvent(State state, EventQueue queue) {
        super(state, queue, 0);
    }

    /**
     * använder överklassens metod
     */
    @Override
    public void runEvent() {
        super.runEvent();
    }
}
