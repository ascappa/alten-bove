package alten.date;

import java.time.LocalDateTime;

public class Event {
    private String name;
    private LocalDateTime date;

    public Event(String name, LocalDateTime date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
