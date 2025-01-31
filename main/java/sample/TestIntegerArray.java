package sample;

public class TestIntegerArray {
    public static void main(String[] args) {
        TestIntegerArray t1 = new TestIntegerArray();
        String res = t1.removeDigit("9239", '9');
        System.out.println("Result = " + res);

        String s1 = "2998589353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        String s2 = "2998389353917872714814599237991174513476623756395992135212546127959342974628712329595771672911914471";
        System.out.println("string compare = " + s1.compareTo(s2));
    }

    public String removeDigit(String number, char digit) {
        char[] numArr = number.toCharArray();
        int[] positions = new int[numArr.length];
        int p = 0;
        for (int i=0; i < numArr.length;i++) {
            if (numArr[i] == digit) {
                positions[p++] = i;
                System.out.println("positions = " + i);
            }
        }

        String resp = "";
        for (int i=0; i < p; i++) {
            String temp = number.substring(0, positions[i]);
            if ((positions[i] + 1) < number.length())
                temp = temp + number.substring(positions[i] + 1, number.length());
            if (temp.compareTo(resp) > 0) resp = temp;
        }

        return resp;
    }
}
