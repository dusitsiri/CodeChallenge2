import java.time.LocalDate;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] monthNotLeapYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; //365
        int[] monthLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  //366

        //Christian era
        String input = "14/2/2563";
        String[] valentine = input.split("/");
        int thisAD = Integer.parseInt(valentine[2])-543;    //AD or A.D. means Christian era
        System.out.println("Input: "+input);

        //find year
        int remainDay = 1500;
        int countYear = 0;
        int countLeapDay = 0;
        while (remainDay > 0){
            if (remainDay - 366 <= 0) break;
            else if(isLeapYear(thisAD)) {
                remainDay = remainDay - IntStream.of(monthLeapYear).sum();  //Day - 366
                countLeapDay+=1;
            }
            else remainDay = remainDay - IntStream.of(monthNotLeapYear).sum();  //Day - 365
            thisAD = thisAD+1;  //each loop increase year by 1
            countYear = countYear+1;
        }


        //find date month
        int countMonth = Integer.parseInt(valentine[1]);
        if (isLeapYear(thisAD)){
            for (int i = Integer.parseInt(valentine[1])-1; i < monthLeapYear.length; i++) { //index of month
                if (remainDay > monthLeapYear[i] && i+1 == Integer.parseInt(valentine[1])){
                    remainDay = remainDay - (monthLeapYear[i] - Integer.parseInt(valentine[0]));
                    countLeapDay+=1;
                } else if (remainDay > monthLeapYear[i]){
                    remainDay = remainDay - monthLeapYear[i];
                } else {
                    break;
                }
                countMonth = countMonth + 1;
            }
        } else {
            for (int i = Integer.parseInt(valentine[1])-1; i < monthNotLeapYear.length; i++) { //index of month
                if (Integer.parseInt(valentine[0]) > 0 && i+1 == Integer.parseInt(valentine[1])){
                    remainDay = remainDay - (monthNotLeapYear[i] - Integer.parseInt(valentine[0]));
                } else if (remainDay > monthNotLeapYear[i]){
                    remainDay = remainDay - monthNotLeapYear[i];
                } else {
                    break;
                }
                countMonth = countMonth + 1;
            }
        }
        //Answer #1
        String nextDay = remainDay+"/"+countMonth+"/"+(thisAD+543);
        System.out.println("Next 1500 days from Valentine's day is: "+nextDay);

        //Answer #2
        LocalDate date = LocalDate.of(thisAD, countMonth, remainDay);
        System.out.println("Next 1500 days from Valentine's day is: "+date.getDayOfWeek());

        //Answer #3
        System.out.println("Next 1500 days from Valentine's day, There are 29 days that "+countLeapDay+" days");

    }

    public static boolean isLeapYear(int year){
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
