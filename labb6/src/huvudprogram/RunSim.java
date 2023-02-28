package huvudprogram;

import allmänt.EventQueue;
import allmänt.Simulator;
import allmänt.StopEvent;
import snabbköp.SnabbköpState;
import snabbköp.SnabbköpView;
import snabbköp.snabbköpsEvent.CloseStoreEvent;
import snabbköp.snabbköpsEvent.SnabbköpStartEvent;

public class RunSim {
    public static void main(String[] args) {
        SnabbköpState state = new SnabbköpState(5,2, 1.0, 0.5, 1.0, 2.0, 3.0, 1234);
        EventQueue queue = new EventQueue();
        queue.insert(new SnabbköpStartEvent(state, queue));
        queue.insert(new StopEvent(state, queue, 999));
        queue.insert(new CloseStoreEvent(state, queue, 10));

        SnabbköpView view = new SnabbköpView(state);
        state.addObserver(view);

        Simulator sim = new Simulator(state, queue);
        sim.run();
    }
}
