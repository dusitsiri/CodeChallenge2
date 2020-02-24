import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] month1 = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] month2 = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String input = "14/02/2563";

        String[] valentine = input.split("/");
        int thisAD = Integer.parseInt(valentine[2])-543;


    }

    public boolean isLeapYear(int year){
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }
}
