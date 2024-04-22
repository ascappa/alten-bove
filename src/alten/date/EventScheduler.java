package alten.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventScheduler {
    private final List<Event> events;

    public EventScheduler(List<Event> events) {
        this.events = events;
    }

    public EventScheduler() {
        this.events = new ArrayList<>();
    }

    public void addEvent(Event event) {
        events.add(event);
    }

    public List<Event> getEventsByDate(LocalDate date) {
        List<Event> filteredEvents = new ArrayList<>();
        for (Event e : events) {
            LocalDateTime currentEventDate = e.getDate();
            if (currentEventDate.toLocalDate().isEqual(date)) {
                filteredEvents.add(e);
            }
        }
        return filteredEvents;
    }

    public List<Event> getEvents() {
        return events;
    }
}
