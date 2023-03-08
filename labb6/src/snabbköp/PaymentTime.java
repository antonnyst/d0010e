/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package snabbköp;

import java.util.Random;
/**
* Fabrik för att räkna ut beräknad tid för ett PaymentEvent.
*/
public class PaymentTime {
    private Random random;
    private double min;
    private double max;
    /**
    * Lägger till en kund sist i kön
    * @param f Fröet som används för slumpgeneratorn
    * @param min Minsta mängden tid som tar för att betala
    * @param max Maximala mängden tid som tar för att betala
    */
    public PaymentTime(long f, double min, double max) {
        this.random = new Random(f);
        this.min = min;
        this.max = max;
    }

    /**
    * Beräknar när en betalning är klar utifrån nuvarande tid
    * @param currentTime Nuvarande tid
    * @return Tiden som betalningen förväntas vara klar
    */
    public double finishTime(double currentTime) {
        return currentTime + min + random.nextDouble()*(max-min);
    }
    
    /**
    * Returnerar minsta tiden som ett betalningevent förväntas ta
    * @return Minsta tiden som ett betalningevent förväntas ta
    */
    public double getMin() {
        return this.min;
    }
    /**
    * Returnerar största tiden som ett betalningevent förväntas ta
    * @return Största tiden som ett betalningevent förväntas ta
    */
    public double getMax() {
        return this.max;
    }
}
