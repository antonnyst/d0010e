package snabbköp;

import java.util.Random;

public class ArrivalTime {
    private Random random;
    private double lambda;
    
    public ArrivalTime(long f, double lambda) {
        this.random = new Random(f);
        this.lambda = lambda;
    }

    public double finishTime(double currentTime) {
        // Exponentialdistrubering med lambda
        return currentTime + (Math.log(1-random.nextDouble())/(-lambda));
    }
}
