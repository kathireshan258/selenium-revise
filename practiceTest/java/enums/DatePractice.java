package practiceTest.java.enums;

/**
 * 7. Date and Time
 * Assignment:
 * Create a program that displays the current date and time, formats it in
 * different styles, and calculates the number of days between two dates.
 * Sample Input:
 * Enter date 1 (yyyy-mm-dd): 2025-06-01
 * Enter date 2 (yyyy-mm-dd): 2025-06-10
 * Expected Output:
 * Days between: 9
 * Formatted Date: 01 Jun 2025
 * */

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

class DatePractice {
    static void main(String[] args) {
        String date1 = "2025-06-10";
        String date2 = "2025-06-20";
        System.out.println("Formatted Date: " +formattedDate(date1));
        System.out.println("Days between: " + daysBetween(date1, date2));
    }

    private static String formattedDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        Date dateObj = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy");
//        dateFormat.format(localDate);
        return dateFormat.format(dateObj);
    }

    private static long daysBetween(String date1, String date2) {
        LocalDate localDateObj1 = LocalDate.parse(date1);
        LocalDate localDateObj2 = LocalDate.parse(date2);
        return ChronoUnit.DAYS.between(localDateObj1,localDateObj2);
    }
}
