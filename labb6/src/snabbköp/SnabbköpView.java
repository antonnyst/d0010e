package snabbköp;

import java.util.Observable;

import allmänt.Event;
import allmänt.State;
import allmänt.View;

public class SnabbköpView extends View {
    
    public SnabbköpView(State state) {
        super(state);

        // Print the skit

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
