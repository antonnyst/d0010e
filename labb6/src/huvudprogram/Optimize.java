package huvudprogram;

import javax.lang.model.util.ElementScanner14;

import allmänt.EventQueue;
import allmänt.Simulator;
import allmänt.StopEvent;
import snabbköp.SnabbköpState;
import snabbköp.SnabbköpView;
import snabbköp.snabbköpsEvent.CloseStoreEvent;
import snabbköp.snabbköpsEvent.SnabbköpStartEvent;
import java.util.Random;

public class Optimize {
    
    public static final int M = 5;
    public static final double L = 1;

    public static final double LOW_COLLECTION_TIME = 0.5d;
    public static final double HIGH_COLLECTION_TIME = 1d;

    public static final double LOW_PAYMENT_TIME = 2d;
    public static final double HIGH_PAYMENT_TIME = 3d;

    public static final int SEED = 1234;
    public static final double END_TIME = 10.0d;
    public static final double STOP_TIME = 999.0d;

    int result = metod3(M,L,LOW_COLLECTION_TIME,HIGH_COLLECTION_TIME,LOW_PAYMENT_TIME,HIGH_PAYMENT_TIME,END_TIME,STOP_TIME,SEED);



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

    public int metod3(int maxKunder, Double lambda,Double kmin,Double kmax,double pmin, double pmax, int f){
        int antalGångerFåttSammaReturn = 0;
        Random rand = new Random(f);


        int senastReturn = findOpt(maxKunder, lambda, kmin, kmax, pmin, pmax, rand.nextInt());



        while (antalGångerFåttSammaReturn < 100){
            int currentReturnedMax = findOpt(maxKunder, lambda, kmin, kmax, pmin, pmax, rand.nextInt());

            if (senastReturn <= currentReturnedMax){
                antalGångerFåttSammaReturn++;
            }
            else{
                senastReturn = currentReturnedMax;
                antalGångerFåttSammaReturn = 0;
            }
        }
        return senastReturn;
    }
    
}
