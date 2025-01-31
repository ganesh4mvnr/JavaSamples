import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestAnagram {
    public static void main(String[] args) {
        String input = "welcome";
        System.out.println(reverse(input, input.length()));

        //System.out.println("isValidAnagram: " + isValidAnagram("cbaa", "aacb"));
        Map<Integer, Integer> myMap = new HashMap<>();
        myMap.put(10, 1);
        myMap.put(50, 3);
        myMap.put(150, 2);
        Integer max = myMap.entrySet().stream().max(Map.Entry.comparingByValue())
            .map(Map.Entry::getKey).orElse(0);
        System.out.println("max= " +max);
    }

    static String reverse(String inp, int index) {
        if (index == 0) return "";
        return inp.charAt(index-1) + reverse(inp, index-1);
    }

    static boolean isValidAnagram(String input1, String input2) {

        if (input1.length() != input2.length()) return false;

        Map<Character, Integer> couterMap1 = new HashMap<>();
        Map<Character, Integer> couterMap2 = new HashMap<>();

        for (int i=0;i<input1.length();i++) {
            char ch1 = input1.charAt(i);
            int count1 = couterMap1.getOrDefault(ch1, 0);
            couterMap1.put(ch1, count1 + 1);

            char ch2 = input2.charAt(i);
            int count2 = couterMap2.getOrDefault(ch2, 0);
            couterMap2.put(ch2, count2 + 1);
        }

        for (char c: input1.toCharArray()) {
            if (couterMap1.get(c) != couterMap2.get(c)) {
                return false;
            }
        }

        Iterator<Map.Entry<Character, Integer>> iterable = couterMap1.entrySet().iterator();
        while (iterable.hasNext()) {
            Map.Entry<Character, Integer> entry = iterable.next();
            System.out.println("Char: " + entry.getKey() + " | count: " + entry.getValue());
            if (entry.getValue() == 1) {
                System.out.println("First non-repeated char: " + entry.getKey());
                break;
            }
        }

        return true;
    }
}
