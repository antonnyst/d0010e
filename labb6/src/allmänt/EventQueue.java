/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */package allmänt;

import java.util.ArrayList;

public class EventQueue {
    
    ArrayList<Event> content;

    public EventQueue() {
        content = new ArrayList<Event>();
    }

    public void insert(Event event) {
        for (int i = 0; i < content.size(); i++) {
            if (event.getTime() < content.get(i).getTime()) {
                content.add(i, event);
                return;
            }
        }
        content.add(event);
    }

    public Event next() {
        return content.remove(0);
    }
}
