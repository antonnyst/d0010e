package huvudprogram;

import allmänt.EventQueue;
import allmänt.Simulator;
import allmänt.StopEvent;
import snabbköp.SnabbköpState;
import snabbköp.SnabbköpView;
import snabbköp.snabbköpsEvent.CloseStoreEvent;
import snabbköp.snabbköpsEvent.SnabbköpStartEvent;

public class Optimize {
    




    public SnabbköpState runOptSim(int maxKunder,int antalKassor, Double lambda,Double kmin,Double kmax,double pmin, double pmax, int f){
        SnabbköpState state = new SnabbköpState(maxKunder,antalKassor,lambda,kmin,kmax,pmin,pmax,f);
        EventQueue queue = new EventQueue();

        queue.insert(new SnabbköpStartEvent(state, queue));
        queue.insert(new StopEvent(state, queue, 999));
        queue.insert(new CloseStoreEvent(state, queue, 10));
        
        Simulator sim = new Simulator(state, queue);
        sim.run();
        return state;
    }

    public int findOpt(int maxKunder, Double lambda,Double kmin,Double kmax,double pmin, double pmax, int f){
        for (int i = 1; i <= maxKunder; i++){
            if (runOptSim(maxKunder,i,lambda,kmin,kmax,pmin,pmax,f).getAntalKunderMissat() == 0){
                return i;
            }
        }
        return maxKunder;
    }

    
}
