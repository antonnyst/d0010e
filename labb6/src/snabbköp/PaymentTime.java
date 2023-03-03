/** Ovin Malcolm, Nyström Anton, Gista Nikolaos, Souza Delfino Clara */
package snabbköp;

import java.util.Random;

public class PaymentTime {
    private Random random;
    private double min;
    private double max;
    
    public PaymentTime(long f, double min, double max) {
        this.random = new Random(f);
        this.min = min;
        this.max = max;
    }

    public double finishTime(double currentTime) {
        return currentTime + min + random.nextDouble()*(max-min);
    }

    public double getMin() {
        return this.min;
    }
    public double getMax() {
        return this.max;
    }
}
