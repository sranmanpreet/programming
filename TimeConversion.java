import java.io.*;

public class TimeConversion {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        String amPm = s.substring(8, 10);
        String hoursString = s.substring(0, 2);
        Integer hours = Integer.parseInt(hoursString);
        if(amPm.equalsIgnoreCase("AM") && hours == 12){
            hoursString = "00";
        }
        if(amPm.equalsIgnoreCase("PM") && hours<12){
            hours = 12 + hours;
            hoursString = hours.toString();
        }
        return hoursString + s.substring(2, 8);
    }

    public static void main(String[] args) throws IOException {
        String s = "01:01:00AM";

        String result = timeConversion(s);
        System.out.println(result);
    }
}
