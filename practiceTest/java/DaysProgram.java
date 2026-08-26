package practiceTest.java;

import practiceTest.java.enums.Days;

/**
 * 6. Enums
 * Assignment:
 * Create an enum for the days of the week.
 * Write a program that takes a day as input and prints whether it's a weekday
 * or weekend.Sample Input:Enter day: SUNDAYExpected Output:SUNDAY is a weekend
 * */


class DaysProgram {
    static void main(String[] args) {
        String day = "Thursday";
        System.out.println(daysText(day));
    }

    private static String daysText(String day) {
        Days days;
        switch(day.toLowerCase()) {
            case "monday" -> days = Days.MONDAY;
            case "tuesday" -> days = Days.TUESDAY;
            case "wednesday" -> days = Days.WEDNESDAY;
            case "thursday" -> days = Days.THURSDAY;
            case "friday" -> days = Days.FRIDAY;
            case "saturday" -> days = Days.SATURDAY;
            default -> days = Days.SUNDAY;
        }
        return days.name() + " is a " + days.getValue();
    }
}
