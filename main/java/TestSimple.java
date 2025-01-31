import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSimple {
    private String value = "Enclosing scope value";

    public static void main(String[] args) {
        String storeId = "11334";
        int st = 7;
        int[] numbers = {10, 20};
        int[] filteredNums = Arrays.stream(numbers)
                .filter(n-> n <= 10).toArray();
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.toArray();
        storeId.toCharArray();
        resultList.add(Arrays.asList(10));

        st = st / 10;
        System.out.println("st ->" + st);

        st = st / 10;
        System.out.println("st ->" + st);
    }
}
