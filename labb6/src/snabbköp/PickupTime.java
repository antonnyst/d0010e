/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package snabbköp;

import java.util.Random;

/**
* Fabrik för att räkna ut beräknad tid för ett PickupEvent.
*/
public class PickupTime {
    private Random random;
    private double min;
    private double max;
    
    /**
    * Konstruktor för PickupTime
    * @param f Fröet som används för slumpgeneratorn
    * @param min Minsta mängden tid som tar för att plocka  
    * @param max Maximala mängden tid som tar för att plocka
    */
    public PickupTime(long f, double min, double max) {
        this.random = new Random(f);
        this.min = min;
        this.max = max;
    }

    /**
    * Beräknar när en kund förväntas plocka klart utifrån nuvarande tid
    * @param currentTime Nuvarande tid
    * @return Tiden när en kund ska ha plockat klart
    */
    public double finishTime(double currentTime) {
        return currentTime + random.nextDouble(min, max);
    }

    /**
    * Returnerar minsta tiden som ett plockevent förväntas ta
    * @return Minsta tiden som ett plockevent förväntas ta
    */
    public double getMin() {
        return this.min;
    }

    /**
    * Returnerar största tiden som ett plockevent förväntas ta
    * @return Största tiden som ett plockevent förväntas ta
    */
    public double getMax() {
        return this.max;
    }
}
