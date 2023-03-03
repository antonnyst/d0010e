package huvudprogram;

import allmänt.EventQueue;
import allmänt.Simulator;
import allmänt.StopEvent;
import snabbköp.SnabbköpState;
import snabbköp.snabbköpsEvent.CloseStoreEvent;
import snabbköp.snabbköpsEvent.SnabbköpStartEvent;
import java.util.Random;

public class Optimize {
    

    public static void main(String[] args) {
        int result = metod3(K.M,K.L,K.LOW_COLLECTION_TIME,K.HIGH_COLLECTION_TIME,K.LOW_PAYMENT_TIME,K.HIGH_PAYMENT_TIME,K.SEED,K.END_TIME,K.STOP_TIME);
        System.out.println("result : " + result);
    }




    public static SnabbköpState runOptSim(int maxKunder,int antalKassor, Double lambda,Double kmin,Double kmax,double pmin, double pmax, int f, double endTime, double stopTime){
        SnabbköpState state = new SnabbköpState(maxKunder,antalKassor,lambda,kmin,kmax,pmin,pmax,f);
        EventQueue queue = new EventQueue();

        queue.insert(new SnabbköpStartEvent(state, queue));
        queue.insert(new StopEvent(state, queue, stopTime));
        queue.insert(new CloseStoreEvent(state, queue, endTime));
        
        Simulator sim = new Simulator(state, queue);
        sim.run();
        return state;
    }

    public static int findOpt(int maxKunder, Double lambda,Double kmin,Double kmax,double pmin, double pmax, int f, double endTime, double stopTime){

        int lowestMissed = Integer.MAX_VALUE;
        int lowestMissedLowesetIndex = 0;

        for(int i = 1; i <= maxKunder; i++) {
            int miss = runOptSim(maxKunder, i, lambda, kmin, kmax, pmin, pmax, f, endTime, stopTime).getAntalKunderMissat();

            if (miss == 0) {
                return i;
            }
            if (miss < lowestMissed) {
                lowestMissed = miss;
                lowestMissedLowesetIndex = i;
            }
        }

        System.out.println(lowestMissedLowesetIndex);

        return lowestMissedLowesetIndex;        
    }

    public static int metod3(int maxKunder, Double lambda,Double kmin,Double kmax,double pmin, double pmax, int f, double endTime, double stopTime){
        int counter = 0;
        Random rand = new Random(f);


        int senastReturn = findOpt(maxKunder, lambda, kmin, kmax, pmin, pmax, rand.nextInt(), endTime, stopTime);



        while (counter < 100){
            int currentReturnedMax = findOpt(maxKunder, lambda, kmin, kmax, pmin, pmax, rand.nextInt(),endTime,stopTime);
            System.out.println(currentReturnedMax);
            if (currentReturnedMax <= senastReturn){
                System.out.println("same");
                counter++;
            }
            else{
                System.out.println("higher");
                senastReturn = currentReturnedMax;
                counter = 0;
            }
        }
        return senastReturn;
    }
    
}
