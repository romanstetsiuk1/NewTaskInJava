package TimeExample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TasksTime {

    //    Check if date in String is Friday 13. String yyyy-MM-dd
    public static boolean its13Friday(String str) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate chekingDay = LocalDate.parse(str, formatter);
        DayOfWeek whatDay = chekingDay.getDayOfWeek();
        int dayOfWeek = whatDay.getValue();
        int dayOfMonth = chekingDay.getDayOfMonth();
        if (dayOfMonth == 13 && dayOfWeek == 5) {
            return true;
        }
        return false;
    }

    /*
        Method get 2 paremetrs:
            - Name day of week
            - N
        return: name day of week after N days
     */
    public static String nameDayOfWeek(String dayOfWeekBegin, int numberOfDaysByUser) {
        String dayOfWeekReult = "";
        String resultMethod;
        int numberDayOfWeekBegin = 0, numberDayOfWeekResult;

        if (dayOfWeekBegin.equals("sunday")) {
            numberDayOfWeekBegin = 0;
        }
        if (dayOfWeekBegin.equals("monday")) {
            numberDayOfWeekBegin = 1;
        }
        if (dayOfWeekBegin.equals("tuesday")) {
            numberDayOfWeekBegin = 2;
        }
        if (dayOfWeekBegin.equals("wednesday")) {
            numberDayOfWeekBegin = 3;
        }
        if (dayOfWeekBegin.equals("thursday")) {
            numberDayOfWeekBegin = 4;
        }
        if (dayOfWeekBegin.equals("friday")) {
            numberDayOfWeekBegin = 5;
        }
        if (dayOfWeekBegin.equals("saturday")) {
            numberDayOfWeekBegin = 6;
        }

        numberDayOfWeekResult = (numberDayOfWeekBegin + numberOfDaysByUser) % 7;

        if (numberDayOfWeekResult == 0)
            dayOfWeekReult = "sunday";
        if (numberDayOfWeekResult == 1)
            dayOfWeekReult = "monday";
        if (numberDayOfWeekResult == 2)
            dayOfWeekReult = "tuesday";
        if (numberDayOfWeekResult == 3)
            dayOfWeekReult = "wednesday";
        if (numberDayOfWeekResult == 4)
            dayOfWeekReult = "thursday";
        if (numberDayOfWeekResult == 5)
            dayOfWeekReult = "friday";
        if (numberDayOfWeekResult == 6)
            dayOfWeekReult = "saturday";

        resultMethod = "after " + numberOfDaysByUser + " of " + dayOfWeekBegin + " will be: " + dayOfWeekReult;
        return resultMethod;
    }

    //    Method show how many days in month
    public static Map<Integer, List<Integer>> howManyDaysInMonth(String year) {

        Map<Integer, List<Integer>> inThisYear = new HashMap<>();

        return inThisYear;
    }

    public static void main(String[] args) {

        System.out.println(its13Friday("2018-07-13"));
        System.out.println(its13Friday("2018-07-15"));
        System.out.println(its13Friday("2018-03-13"));

        System.out.println(nameDayOfWeek("monday", 3));
        System.out.println(nameDayOfWeek("monday", 1));
        System.out.println(nameDayOfWeek("thursday", 2));

    }

}
