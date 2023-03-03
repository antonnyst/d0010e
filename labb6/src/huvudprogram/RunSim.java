package huvudprogram;

import java.util.Random;

import allmänt.EventQueue;
import allmänt.Simulator;
import allmänt.StopEvent;
import snabbköp.SnabbköpState;
import snabbköp.SnabbköpView;
import snabbköp.snabbköpsEvent.CloseStoreEvent;
import snabbköp.snabbköpsEvent.SnabbköpStartEvent;

public class RunSim {
    public static void main(String[] args) {
        SnabbköpState state = new SnabbköpState(K.M,3, K.L, K.LOW_PAYMENT_TIME, K.HIGH_PAYMENT_TIME, K.LOW_COLLECTION_TIME, K.HIGH_COLLECTION_TIME, K.SEED);
        EventQueue queue = new EventQueue();
        queue.insert(new SnabbköpStartEvent(state, queue));
        queue.insert(new StopEvent(state, queue, K.STOP_TIME));
        queue.insert(new CloseStoreEvent(state, queue, K.END_TIME));

        SnabbköpView view = new SnabbköpView(state);
        state.addObserver(view);

        Simulator sim = new Simulator(state, queue);
        sim.run();

    }
}
