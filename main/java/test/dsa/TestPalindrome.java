package test.dsa;

public class TestPalindrome {
    public static void main(String[] args) {
        int maxLength = 1, start = 0;
        String str = "acbbcdb";
        // Nested loop to mark start and end index
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                int flag = 1;

                // Check palindrome
                for (int k = 0; k < (j - i + 1) / 2; k++)
                    if (str.charAt(i + k) != str.charAt(j - k)) {
                        flag = 0;
                        break;
                    }

                // Palindrome
                if (flag!=0 && (j - i + 1) > maxLength) {
                    start = i;
                    maxLength = j - i + 1;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i=start; i<= (start + maxLength) - 1;i++) {
            result.append(str.charAt(i));
        }
        System.out.println("Given string = " + str);
        System.out.println("start = " + start);
        System.out.println("maxLength = " + maxLength);
        System.out.println("Result = " + result);

        System.out.println("Optimized palindrome: " + longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        // acdbabba
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
