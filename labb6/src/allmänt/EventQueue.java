package allmänt;

import java.util.ArrayList;

public class EventQueue {
    
    ArrayList<Event> content;

    public EventQueue() {
        content = new ArrayList<Event>();
    }

    public void insert(Event event) {
        // TODO
    }

    public Event next() {
        return content.remove(0);
    }
}
