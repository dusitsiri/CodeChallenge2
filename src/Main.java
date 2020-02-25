import java.time.LocalDate;
import java.util.Date;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] monthNotLeapYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //365
        int[] monthLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  //266

        //Christian era
        String input = "14/2/2563";
        String[] valentine = input.split("/");
        int thisAD = Integer.parseInt(valentine[2])-543;    //AD or A.D. means Christian era

        //find total day, Next 1500 days
        int day = 1500;
        int countYear = 0;
        while (day > 0){
            System.out.println(day);
            if (day - 366 <= 0) break;
            else if(isLeapYear(thisAD)) day = day - IntStream.of(monthLeapYear).sum();
            else day = day - IntStream.of(monthNotLeapYear).sum();
            thisAD = thisAD+1;
            countYear = countYear+1;
        }

        System.out.print("remain days: "+day+"\n");
        System.out.print("number of year: "+countYear);



    }

    public static boolean isLeapYear(int year){
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

//    int valentineYear = Integer.parseInt(valentine[2])-543;
//    int valentineMonth = Integer.parseInt(valentine[1]);
//    int valentineDate = Integer.parseInt(valentine[0]);
//    LocalDate date = LocalDate.of(valentineYear, valentineMonth, valentineDate);
}
