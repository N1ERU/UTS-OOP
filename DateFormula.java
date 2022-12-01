
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class date_formula {

    public static void main(String[] args) {
        String d1 = "2022-01-01";
        LocalDate localDate = LocalDate.now();// For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
        String d2 = localDate.format(formatter);

        if (d1.compareTo(d2) > 0) {
            System.out.println("Date 1 happens after Date 2");
        } 
        else if (d1.compareTo(d2) < 0) {
            System.out.println("Date 1 happens before Date 2");
        } 
        else if (d1.compareTo(d2) == 0) {
            System.out.println("Both dates are same date");
        }

        // create a LocalDate object
        LocalDate date = LocalDate.parse("2022-05-11");

        // print instance
        System.out.println("Start LocalDate before \t\t: "
                + date);

        // add 49 days
        LocalDate returnvalue = date.plusDays(49);

        // print result
        System.out.println("LocalDate after "
                + "adding days \t: " + returnvalue);
    }

}
