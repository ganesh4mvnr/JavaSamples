package sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SimpleCode {
    public static void main(String[] args) throws ParseException {
        Map<Character, Character> myMap = Map.of('C', 'c','A','a');
        List<String> aList = List.of();
        int[] arr = {4, 2, 7, 9, 6};
        int[] res = Arrays.copyOfRange(arr, 2, 5);

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date d1 = dateFormat.parse("10:05");
        Date d2 = dateFormat.parse("13:35");
        long diff = d2.getTime() - d1.getTime();

        long diffSeconds = diff / 1000;
        long diffMinutes = diff / (60 * 1000) % 60;
        System.out.println(diffMinutes + " minutes, ");
        System.out.println(diffSeconds + " seconds.");

        Arrays.stream(res).forEach(System.out::println);
    }

    public static String getLeftRotationalString(String input, int num) {
        if (num == 0) return input;

        StringBuilder buffer = new StringBuilder(input.substring(1));
        buffer.append(input.charAt(0));
        return getLeftRotationalString(buffer.toString(), num - 1);
    }
}
