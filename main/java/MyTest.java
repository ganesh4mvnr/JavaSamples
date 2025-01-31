import java.util.HashMap;
import java.util.Map;

public class MyTest {
    public static void main(String[] args) {
        MyTest mt = new MyTest();
        Map<Integer, String> testMap = new HashMap<>(){{
            put(4, "123");
            put(3, "878");
            put(5, "321");
            put(5, "656");
            put(1, "321");
        }};
        long stTime = System.currentTimeMillis();
        System.out.println("Count= " + mt.getIterCount(1010));
        System.out.println("Time taken ms: " + (System.currentTimeMillis() - stTime));

        System.out.println("testMap => " + testMap);

    }

    public int getIterCount(int num) {
        int i=1;

        for (;i < 100;i++) {
            if (isPalindrome(num)) {
                System.out.println("Yes, palindrome num: " + num);
                return i;
            } else {
                num = num + reverseNumber(num, 0);
            }
        }
        return -1;
    }
    public boolean isPalindrome(int number) {
        int divisor = 1;

        if (number < 10) return true;

        while (number / divisor >= 10 ) {
            divisor *= 10;
        }

        while (number != 0) {
            int initial = number / divisor;
            int last = number % 10;
            if (initial != last) {
                return false;
            }
            number = (number % divisor) / 10;
            divisor /= 100;
        }

        return true;
    }

    public int reverseNumber(int number, int rev) {
        if (number == 0) return rev;
        rev = (rev * 10) + (number % 10);
        return reverseNumber(number / 10, rev);

    }

}
