/** Ovin Malcolm, Nyström Anton, Gista Nikolaos, Souza Delfino Clara */
package snabbköp;

import java.util.Random;

public class PickupTime {
    private Random random;
    private double min;
    private double max;
    
    public PickupTime(long f, double min, double max) {
        this.random = new Random(f);
        this.min = min;
        this.max = max;
    }

    public double finishTime(double currentTime) {
        return currentTime + random.nextDouble(min, max);
    }

    public double getMin() {
        return this.min;
    }
    public double getMax() {
        return this.max;
    }
}
