package snabbköp;

import java.util.Observable;

import allmänt.Event;
import allmänt.State;
import allmänt.View;

public class SnabbköpView extends View {
    
    public SnabbköpView(SnabbköpState state) {
        super(state);

        // Print the skit
        System.out.print(String.format(
            """
            PARAMETRAR
            ==========
            Antal kassor, N..........: %s
            Max som ryms, M..........: %s
            Ankomshastighet, lambda..: %s
            Plocktider, [P_min..Pmax]: [%s..%s]
            Betaltider, [K_min..Kmax]: [%s..%s]
            Frö, f...................: %s
            FÖRLOPP
            =======
            Tid Händelse Kund ? led ledT I $ :-( köat köT köar [Kassakö..]
            """,
            state.getAntalKassor(),
            state.getMaxAntalKunder(),
            state.getArrivalTime().getLambda(),
            state.getPickupTime().getMin(),
            state.getPickupTime().getMax(),
            state.getPaymentTime().getMin(),
            state.getPaymentTime().getMax(),
            state.getSeed()
        ));
    }

    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO gör en utskrift    
        Event event = (Event) arg1;
        
        System.out.println("Event som ska hända " + event.toString());
        System.out.println("tid " + event.getTime());
        
        System.out.println("kö " + ((SnabbköpState) this.state).getKassakö().toString());
    }
}
