package alten.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestDate {
    public static void main(String[] args) {
        EventScheduler myScheduler = new EventScheduler();
        LocalDateTime dataCorrente = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        myScheduler.addEvent(new Event("uscire con amici", LocalDateTime.of(2020, 4, 20, 21, 34, 30)));
        myScheduler.addEvent(new Event("concerto", LocalDateTime.of(2020, 8, 10, 11, 34, 30)));
        myScheduler.addEvent(new Event("programmare", LocalDateTime.of(2022, 9, 20, 21, 34, 30)));
        myScheduler.addEvent(new Event("mangiare", LocalDateTime.of(2020, 4, 20, 1, 34, 30)));
        myScheduler.addEvent(new Event("dormire", LocalDateTime.of(2010, 4, 20, 23, 34, 30)));
        myScheduler.addEvent(new Event("leggere un libro", LocalDateTime.of(2020, 8, 10, 21, 34, 30)));
        System.out.println(myScheduler.getEventsByDate(LocalDate.of(2020, 8, 10)));
        System.out.println(dataCorrente.toLocalDate());
        System.out.println(dataCorrente.toLocalTime());
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dataCorrente));
        System.out.println(dataCorrente.format(timeFormatter));

    }
}
