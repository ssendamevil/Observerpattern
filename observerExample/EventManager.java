package observerExample;

import java.io.File;
import java.util.*;

public class EventManager {
    Map<String, List<EventListener>> listeners = new HashMap<>();
    public EventManager(String... operations){
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String EventType, EventListener listener){
        List<EventListener> users = listeners.get(EventType);
        users.add(listener);
    }

    public void unsubscribe(String EventType, EventListener listener){
        List<EventListener> users = listeners.get(EventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file){
        List <EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.update(eventType, file);
        }
    }
}
