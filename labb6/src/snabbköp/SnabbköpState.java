package snabbköp;

import allmänt.State;

public class SnabbköpState extends State {
    private int antalKunder, maxAntalKunder, antalKunderHandlat, antalKunderKöat, antalKunderMissat, antalKassor, ledigaKassor;
    private boolean shopOpen = true;
    private double tidLedigaKassor, tidKunderKöat;
    private FIFO kassaKö;
    private ArrivalTime arrivalTime;
    private PickupTime pickupTime;
    private PaymentTime paymentTime;
    private CustomerFactory customerFactory;

    public SnabbköpState(int maxKunder, int antalKassor, double lambda, int kmin, int kmax, int pmin, int pmax, int f)  {
        this.maxAntalKunder = maxKunder;
        this.antalKassor = antalKassor;
        this.ledigaKassor = antalKassor;
        this.arrivalTime = new ArrivalTime(f, lambda);
        this.paymentTime = new PaymentTime(f, kmin, kmax);
        this.pickupTime = new PickupTime(f, pmin, pmax);
        this.kassaKö = new FIFO();
        this.customerFactory = new CustomerFactory();
    }
    
    public int getMaxAntalKunder() {
        return this.maxAntalKunder;
    }
    
    public int getAntalKassor() {
        return this.antalKassor;
    }

    public int getLedigaKassor() {
        return this.ledigaKassor;
    }

    public int getAntalKunder()  {
        return this.antalKunder;
    }

    public void increaseAntalKunder() throws RuntimeException {
        if (antalKunder + 1 > maxAntalKunder) {
            throw new RuntimeException("Too many customers in the store.");
        }
        this.antalKunder++;
    }
    
    public int getAntalKunderKöat()  {
        return this.antalKunderKöat;
    }

    public int getAntalKunderMissat()  {
        return this.antalKunderMissat;
    }

    public double getTidKunderKöat() {
        return this.tidKunderKöat;
    }

    public double getTidLedigaKassor()  {
        return this.tidLedigaKassor;
    }

    public boolean getShopOpen() {
        return this.shopOpen;
    }

    public ArrivalTime getArrivalTime() {
        return this.arrivalTime;
    }

    public PaymentTime getPaymentTime() {
        return this.paymentTime;
    }

    public PickupTime getPickupTime() {
        return this.pickupTime;
    }

    public CustomerFactory getCustomerFactory() {
        return this.customerFactory;
    }

    public FIFO getKassakö()  {
        return this.kassaKö;
    }
    
}
