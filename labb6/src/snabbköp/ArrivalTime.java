/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
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
        // Korrekta matten är (Math.log(1-random.nextDouble())/(-lambda))

        // Håkans nedan               VVVV
        return currentTime + (Math.log(random.nextDouble())/(-lambda));
    }
    public double getLambda() {
        return lambda;
    }
}
