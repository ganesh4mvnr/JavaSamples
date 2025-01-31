import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestValidNumber {

    /**
     * a[i] = (i+1) * x;
     * l <= x <= r
     *
     * For ex, [8,5,6,2,5] and l = 1, r =3
     * here b[0] - false, b[1] - false... b[4] - true because 'x' could be 1.
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {8,5,6,2,5,10};
        int l = 2, r = 8;
        Boolean[] b = new Boolean[arr.length];

        for (int i=0;i<arr.length;i++) {
            boolean isMatchFound = false;
            for (int k=l;k <= r;k++) {
                int x = (i + 1) * k;
                if (arr[i] == x) {
                    isMatchFound = true;
                    break;
                }
            }
            if (isMatchFound) {
                b[i] = true;
            } else {
                b[i] = false;
            }
        }

        Arrays.stream(b).forEach(System.out::println);
        List<Boolean> anList = Arrays.stream(b).collect(Collectors.toList());
    }
}
