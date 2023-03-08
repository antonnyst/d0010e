/** 
 * @author Ovin Malcolm
 * @author Nyström Anton
 * @author Nikolaos
 * @author Delfino Clara 
 */
package allmänt;

import java.util.ArrayList;
/**
 * en lista för att hålla reda på events
 */
public class EventQueue {
    
    ArrayList<Event> content;

    /**
     * skapar en lista för att hålla reda på events
     */
    public EventQueue() {
        content = new ArrayList<Event>();
    }

    /**
     * lägger in event på rätt plats
     * @param eventet som ska in i kön
     */
    public void insert(Event event) {
        for (int i = 0; i < content.size(); i++) {
            if (event.getTime() < content.get(i).getTime()) {
                content.add(i, event);
                return;
            }
        }
        content.add(event);
    }

    /**
     * tar ut och returnerar det första elementet i listan
     * @return förs elementet i listan
     */
    public Event next() {
        return content.remove(0);
    }
}
