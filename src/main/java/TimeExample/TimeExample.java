package TimeExample;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

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

        /*
        TIMESTAMP
        info from: https://www.epochconverter.com/
         */
        long myTimestamp = 1544862554L;
        LocalDateTime myLocalDateTime = LocalDateTime.ofInstant
                (Instant.ofEpochSecond(myTimestamp), TimeZone.getDefault().toZoneId());
        System.out.println(myLocalDateTime);

//      TIME ZONE
        TimeZone myTimeZone = TimeZone.getDefault();
        System.out.println("My time zone is: " + myTimeZone);
        System.out.println("Identyfikator strefy: " + myTimeZone.toZoneId());
        System.out.println("Przesuniecie w stosunku do grintith w sekundach: " + myTimeZone.getRawOffset());

        ZoneId zoneId = ZoneId.of("Europe/Paris");
        System.out.println("W strefie czsowej " + zoneId + " przesuniecie stanowi: "
                + zoneId.getRules().getOffset(Instant.EPOCH));

        Set<String> allZonesId = ZoneId.getAvailableZoneIds();  //get all times zones
        System.out.println(allZonesId);

//        Task: wyswitl wszystkie zony czasowe wraz z przesunieciem w nich
        for (String element : allZonesId) {
            ZoneId tmpZone = ZoneId.of(element);
            System.out.println("W strefie czasowej " + element + " przesuniecie stanowi: " +
                    tmpZone.getRules().getOffset(Instant.EPOCH));
        }

//        Task: Sortowanie zon czasowych wraz z przesunieciem
        Map<String, String> allZoneIdWithTime = new HashMap<>();
        for (String timeZone : allZonesId) {
            ZoneId tmpZone = ZoneId.of(timeZone);
            allZoneIdWithTime.put(timeZone, String.valueOf(tmpZone.getRules().getOffset(Instant.EPOCH)));
        }
        System.out.println(sortByValue(allZoneIdWithTime));

    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

}
