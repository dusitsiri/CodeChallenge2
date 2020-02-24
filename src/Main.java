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
        int day = 0;
        while (day < 1500){
            if(isLeapYear(thisAD)) day = day + IntStream.of(monthLeapYear).sum();
            else day = day + IntStream.of(monthNotLeapYear).sum();
//            System.out.println(day);
            thisAD = thisAD+1;
        }
        int dayExpand = day - (1500 + monthLeapYear[0] + Integer.parseInt(valentine[0]));   //total day sub 1500 days integrate with start valentine's day in first year
//        System.out.println(dayExpand);


    }

    public static boolean isLeapYear(int year){
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

//    int valentineYear = Integer.parseInt(valentine[2])-543;
//    int valentineMonth = Integer.parseInt(valentine[1]);
//    int valentineDate = Integer.parseInt(valentine[0]);
//    LocalDate date = LocalDate.of(valentineYear, valentineMonth, valentineDate);
}
