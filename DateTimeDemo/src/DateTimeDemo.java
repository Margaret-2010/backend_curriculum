import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

public class DateTimeDemo {

    public static void main(String[] args) {

        // Part 1: Length of each month in a given year
        System.out.println("Month lengths for a given year : ");
        reportMonthLengths(2026);

        System.out.println();

        // Part 2: List all Mondays in a given month of the current year
        System.out.println("All Mondays in a given month : ");
        listMondaysInMonth(Month.AUGUST);

        System.out.println();

        // Part 3: Test whether a given date is Friday the 13th 
        System.out.println("Part 3: Is it Friday the 13th? : ");
        LocalDate testDate1 = LocalDate.of(2026, 2, 13);
        LocalDate testDate2 = LocalDate.of(2026, 8, 6);   //

        checkFridayThe13th(testDate1);
        checkFridayThe13th(testDate2);
    }

    public static void reportMonthLengths(int yearValue) {
        Year year = Year.of(yearValue);
        boolean isLeap = year.isLeap();

        System.out.println("Year " + yearValue + " (leap year: " + isLeap + ")");
        for (Month month : Month.values()) {
            int length = month.length(isLeap);
            System.out.println(month + ": " + length + " days");
        }
    }

    public static void listMondaysInMonth(Month month) {
        int currentYear = LocalDate.now().getYear();

        LocalDate firstOfMonth = LocalDate.of(currentYear, month, 1);

        LocalDate firstMonday = firstOfMonth.with(
                TemporalAdjusters.nextOrSame(DayOfWeek.MONDAY)
        );

        System.out.println("Mondays in " + month + " " + currentYear + ":");

        LocalDate current = firstMonday;
        while (current.getMonth() == month) {
            System.out.println(current);
            current = current.plusWeeks(1); // jump to the next Monday
        }
    }

    public static void checkFridayThe13th(LocalDate date) {
        boolean isFriday = date.getDayOfWeek() == DayOfWeek.FRIDAY;
        boolean is13th = date.getDayOfMonth() == 13;

        if (isFriday && is13th) {
            System.out.println(date + " -> Yes, it's Friday the 13th!");
        } else {
            System.out.println(date + " -> No, it's not Friday the 13th.");
        }
    }
}