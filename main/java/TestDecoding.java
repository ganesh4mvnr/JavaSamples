import java.util.Arrays;
import java.util.Map;

public class TestDecoding {
    public static void main(String[] args) {
        String res = getDecodedString("150[cb]");
        System.out.println("res = " + res.length());

        String spl[] = "150[cb]".split("^[a-z]");
        Arrays.stream(spl).forEach(System.out::println);
    }

    public static String getDecodedString(String word) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int val = 0;
        StringBuilder buffer = new StringBuilder();

        for (int i=0; i < word.length();i++ ) {
            char ch = word.charAt(i);
            if (Character.isDigit(ch)) {
                val = Character.getNumericValue(ch);
                if (count > 0) {
                    count = (count * 10) + val;
                } else {
                    count = val;
                }
                continue;
            }
            if (ch == '[') continue;
            else if (ch != ']') {
                buffer.append(ch);
            } else if (ch == ']') {
                while (count-- > 0)
                    result.append(buffer);
                buffer = new StringBuilder();
            }
        }

        return result.toString();
    }
}
