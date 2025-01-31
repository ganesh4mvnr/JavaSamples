import java.util.HashMap;
import java.util.Map;

public class MinInsertPalindrome {

    public static int count;
    public static Map<String, Integer> cacheMap = new HashMap();
    // A Naive recursive Java program to find minimum
// number insertions needed to make a string
// palindrome
    // Recursive function to find minimum number
    // of insertions
    static int findMinInsertions(char str[], int l,
                                 int h) {
        // Base Cases
        int result = 0;
        if (l > h) return Integer.MAX_VALUE;
        if (l == h) return 0;
        if (l == h - 1) return (str[l] == str[h]) ? 0 : 1;
        ++count;

        System.out.println("str[l]: " + str[l] + " | str[h]: " + str[h]);

        // Check if the first and last characters
        // are same. On the basis of the comparison
        // result, decide which subproblem(s) to call

        if (cacheMap.containsKey(str.toString())) {
            return cacheMap.get(str.toString());
        } else {
            if (str[l] == str[h]) {
                result = findMinInsertions(str, l + 1, h - 1);
                cacheMap.put(str.toString(), result);
            } else {
                result = (Integer.min(findMinInsertions(str, l, h - 1),
                        findMinInsertions(str, l + 1, h)) + 1);
                cacheMap.put(str.toString(), result);
            }
        }

        return result;
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        String str= "zzazz";
        System.out.println(findMinInsertions(str.toCharArray(),
                0, str.length()-1));
        System.out.println("No.of recursive calls: " + count);

        System.out.println("Min num of char needed for palindrome: " + noOfAppends(str));
    }


    // Checking if the string is palindrome or not
    static boolean isPalindrome(char []str)
    {
        int len = str.length;

        // single character is always palindrome
        if (len == 1)
            return true;

        // pointing to first character
        int ptr1 = 0;

        // pointing to last character
        int  ptr2 = len-1;

        while (ptr2 >= ptr1)
        {
            if (str[ptr1] != str[ptr2])
                return false;
            ptr1++;
            ptr2--;
        }

        return true;
    }

    // Recursive function to count number of appends
    static int noOfAppends(String s)
    {
        if (isPalindrome(s.toCharArray()))
            return 0;

        // Removing first character of string by
        // incrementing base address pointer.
        s=s.substring(1);

        return 1 + noOfAppends(s);
    }
}
