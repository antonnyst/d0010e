/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;
 
/**
 * kör simulationen
 */
public class Simulator {
    State state;
    EventQueue queue;

    /**
     * sparar de två parametrarna
     * @param tillståndet som programmet befinner sig i
     * @param listan med event
     */
    public Simulator(State state, EventQueue queue) {
        this.state = state;
        this.queue = queue;
    }

    /**
     * kör igenom alla event i listan
     */
    public void run() {
        while (state.stop == false && queue.content.size() > 0) {
            Event nextEvent = queue.next();
            nextEvent.runEvent();
        }
    }
}
