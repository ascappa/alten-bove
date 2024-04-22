package com.alten.date;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TestDate {
    public static void main(String[] args) {
        EventScheduler eventScheduler = new EventScheduler();
        TaskScheduler taskScheduler = new TaskScheduler();
        LocalDateTime dataCorrente = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        eventScheduler.addEvent(new Event("uscire congli amici", LocalDateTime.of(2020, 4, 20, 21, 34, 30)));
        eventScheduler.addEvent(new Event("concerto", LocalDateTime.of(2020, 8, 10, 11, 34, 30)));
        eventScheduler.addEvent(new Event("programmare", LocalDateTime.of(2022, 9, 20, 21, 34, 30)));
        eventScheduler.addEvent(new Event("mangiare", LocalDateTime.of(2020, 4, 20, 1, 34, 30)));
        eventScheduler.addEvent(new Event("dormire", LocalDateTime.of(2010, 4, 20, 23, 34, 30)));
        eventScheduler.addEvent(new Event("leggere un libro", LocalDateTime.of(2020, 8, 10, 21, 34, 30)));

        System.out.println(eventScheduler.getEventsByDate(LocalDate.of(2020, 8, 10)));
        System.out.println(dataCorrente.toLocalDate());
        System.out.println(dataCorrente.toLocalTime());
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd").format(dataCorrente));
        System.out.println(dataCorrente.format(timeFormatter));

        taskScheduler.addTask(new Task("finire l'esercizio sulle date", LocalDate.of(2024, 4, 21)));
        taskScheduler.addTask(new Task("mandare indietro il pacco Amazon", LocalDate.of(2018, 2, 17)));
        taskScheduler.addTask(new Task("pulire casa", LocalDate.of(2024, 4, 25)));
        taskScheduler.addTask(new Task("portare il cane dal veterinario", LocalDate.of(2020, 9, 2)));
        System.out.println(taskScheduler.getTasksByDeadline(LocalDate.of(2018, 2, 17)));
        Task secondTask = taskScheduler.getTask(1);
        Period timeToSecondTask = Period.between(secondTask.getDeadline(), dataCorrente.toLocalDate());
        System.out.printf("Mancano %d anni, %d mesi e %d giorni alla task '%s'\n", timeToSecondTask.getYears(), timeToSecondTask.getMonths(), timeToSecondTask.getDays(), secondTask.getName());
        System.out.println("Mancano " + Duration.between(secondTask.getDeadline().atStartOfDay(), dataCorrente).getSeconds() + " secondi alla task '" + secondTask.getName() + "'");
        System.out.println(ZoneId.systemDefault());
        ZonedDateTime timeInTokyo = ZonedDateTime.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("A Tokyo sono le " + timeInTokyo.format(DateTimeFormatter.ofPattern("HH:mm:ss")) + " del " + timeInTokyo.format(DateTimeFormatter.ofPattern("dd/MM/yy")));
        System.out.println(ZoneId.ofOffset("UTC", ZoneOffset.ofHours(5)).getId());
        System.out.printf("La data e ora correnti con offset di 4 ore sono %s", OffsetDateTime.now().plusHours(4).format(DateTimeFormatter.ofPattern("dd/MM/yy, HH:mm:ss")));
    }
}