public class TestPasswordDecrypt {

    public static void main(String[] args) {
        System.out.println("decryptPassword: " + decryptPassword("hAck3rr4nk"));
    }

    public static String decryptPassword(String s) {
        // Write your code here
        int strLen = s.length();
        StringBuilder buffer = new StringBuilder(s);

        for (int i=0;i<strLen-1;i++) {
            char ch1 = s.charAt(i);
            if (Character.isAlphabetic(ch1) && Character.isUpperCase(ch1)) {
                char nextChar = s.charAt(i+1);
                if (Character.isLowerCase(nextChar)) {
                    String str = String.valueOf(nextChar) + String.valueOf(ch1);
                    buffer.replace(i,i+1, str);
                }
            } else if (Character.isDigit(ch1)) {
                if (s.contains("0")) {
                    int idx = buffer.lastIndexOf("0");
                    buffer.insert(idx, ch1);
                    buffer.deleteCharAt(0);
                }
            }
        }
        String result = buffer.toString();
        result = result.replace("*", "");
        System.out.println("Result: " + result);
        return result;
    }
}
