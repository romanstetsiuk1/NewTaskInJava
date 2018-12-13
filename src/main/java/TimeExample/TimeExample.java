package TimeExample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class TimeExample {

    public static void main(String[] args) {

//        Date
        LocalDate now = LocalDate.now();
        System.out.println("Today is: " + now);

        LocalDate anotherDate = LocalDate.of(2015, 2, 1);
        System.out.println("Another day: " + anotherDate);

        LocalDate anotherDate2 = LocalDate.parse("2015-02-25");
        System.out.println("Parse date from String(YYYY-MM-DD): " + anotherDate2);

        LocalDate tomorrow = now.plus(1L, ChronoUnit.DAYS);
        System.out.println("Tomorrow is: " + tomorrow);

        LocalDate yesterday = now.minusDays(1);
        System.out.println("Yesterday was: " + yesterday);

        DayOfWeek dayOfWeek = now.getDayOfWeek();
        int dayOfWeekAsNumber = dayOfWeek.getValue();
        System.out.println("Day of week today: " + dayOfWeekAsNumber);

        boolean isLeapYear = now.isLeapYear();
        System.out.println("Sprawdza czy ten rok jest przestepny: " + isLeapYear);

        boolean isTomorrowAfterNow = tomorrow.isAfter(now);
        System.out.println("If tomorrow is after now: " + isTomorrowAfterNow);
        System.out.println("----------------------------------------------------");

//        Time
        LocalTime timeNow = LocalTime.now();
        System.out.println("Time now: " + timeNow);

        LocalTime anotherTime = LocalTime.of(15, 20);
        LocalTime anotherTime2 = LocalTime.parse("15:25");
        System.out.println("Another time: " + anotherTime + "\nAnother time by String: " + anotherTime2);

        LocalTime oneHourLater = timeNow.plus(1, ChronoUnit.HOURS);
        LocalTime twoHourLater = timeNow.plusHours(2);

        int hour = timeNow.getHour();

        LocalTime maxTime = LocalTime.MAX;
        System.out.println("Max time value is: " + maxTime);
        System.out.println("----------------------------------------------------");

//        Date & time
        LocalDateTime nowDateTime = LocalDateTime.now();
        System.out.println("Date and time by now is: " + nowDateTime);

        LocalDateTime anotherDateTime = LocalDateTime.of(2017, 2, 15, 6, 01);
        LocalDateTime anotherDateTime2 = LocalDateTime.parse("2015-02-03T06:12:56");

        nowDateTime.plus(1, ChronoUnit.DAYS);
        nowDateTime.minusDays(1);
        System.out.println("----------------------------------------------------");

//        Create date & time by String
        String str = "12-03-1991 06:07";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(str, formatter);
        System.out.println("Przekonwertowana data os uzytkownika: " + dateTime);

//        Create String from the DateTime
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy MM dd HH:mm");
        String nowDateTimeAsString = nowDateTime.format(dtf);
        System.out.println("Date and time is String: " + nowDateTimeAsString);

    }

}
