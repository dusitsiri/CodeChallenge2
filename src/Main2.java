import java.time.LocalDate;
import java.util.stream.IntStream;
public class Main {
    public static void main(String[] args) {
        int[] monthNotLeapYear = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
        int[] monthLeapYear = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  
        String input = "14/2/2563";
        String[] valentine = input.split("/");
        int thisAD = Integer.parseInt(valentine[2])-543;   
        int remainDay = 1500;
        int countYear = 0;
        int countLeapDay = 0;
        while (remainDay > 0){
            if (remainDay - 366 <= 0) break;
            else if(isLeapYear(thisAD)) {
                remainDay = remainDay - IntStream.of(monthLeapYear).sum();  
                countLeapDay+=1;
            }
            else remainDay = remainDay - IntStream.of(monthNotLeapYear).sum();  
            thisAD = thisAD+1;  
            countYear = countYear+1;
        }
    
        if (isLeapYear(thisAD)){
            String dateAndMonth = findDateAndMonth(valentine, monthLeapYear, remainDay);
        } else {
            String dateAndMonth = findDateAndMonth(valentine, monthNotLeapYear, remainDay);
        }

        String nextDay = remainDay+"/"+countMonth+"/"+(thisAD+543);
        System.out.println("Next 1500 days from Valentine's day is: "+nextDay);
        LocalDate date = LocalDate.of(thisAD, countMonth, remainDay);
        System.out.println("Next 1500 days from Valentine's day is: "+date.getDayOfWeek());
        System.out.println("Next 1500 days from Valentine's day, There are 29 days that "+countLeapDay+" days");
    }

    public static String findDateAndMonth(String[] startDate, int[] months, int remainDay){
        String dateString = "";
        int countMonth = Integer.parseInt(startDate[1]);
        for (int i = Integer.parseInt(startDate[1])-1; i < months.length; i++) { 
            if (Integer.parseInt(startDate[0]) > 0 && i+1 == Integer.parseInt(startDate[1])){
                remainDay = remainDay - (months[i] - Integer.parseInt(startDate[0]));
                if (months) countLeapDay+=1;
            } else if (remainDay > months[i]){
                remainDay = remainDay - months[i];
            } else break;
            countMonth = countMonth + 1;
        }
        return dateString;
    }

    public static boolean isLeapYear(int year){ return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0); }
}
