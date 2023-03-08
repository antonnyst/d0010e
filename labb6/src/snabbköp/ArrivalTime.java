/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package snabbköp;

import java.util.Random;

/**
* Fabrik för att räkna ut beräknad tid för ett ArrivalEvent.
*/
public class ArrivalTime {
    private Random random;
    private double lambda;
    
    /**
    * Konstruktor för ArrivalTime
    * @param f Fröet som används för slumpgeneratorn
    * @param lambda Lambdavärdet som används för exponentialfördelningen 
    */
    public ArrivalTime(long f, double lambda) {
        this.random = new Random(f);
        this.lambda = lambda;
    }

    /**
    * Beräknar när nästa kund anländer utifrån nuvarande tid
    * @param currentTime Nuvarande tid
    * @return Tiden när nästa kund anländer
    */
    public double finishTime(double currentTime) {
        // Exponentialdistrubering med lambda
        // Korrekta matten är (Math.log(1-random.nextDouble())/(-lambda))

        // Håkans nedan               VVVV
        return currentTime + (Math.log(random.nextDouble())/(-lambda));
    }

    /**
    * Returnerar lambdavärdet som används för beräkningen
    * @return Lambdavärdet
    */
    public double getLambda() {
        return lambda;
    }
}
