package test.dsa;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestCode {

    public static void main(String[] args) {
        /**String[] name1 = {"abc", "uxy", "ghj"};
        String[] name2 = {"uyh", "abc", "ghj", "ikj"};

        List<String> names = Arrays.asList(name2);
        List<String> names1 = Arrays.asList(name1);

        List<String> result = Stream.of(names, names1).flatMap(List::stream).distinct().collect(Collectors.toList());
        List<String> sortedResult = result.stream().sorted(
                String::compareTo
        ).collect(Collectors.toList());
        System.out.println(sortedResult);**/

        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        List<Integer> numbers = Arrays.asList(2, 10, 20, 3, 1, 17, 90, 100, 56);
        int[] numArr = numbers.stream().mapToInt(i->i).toArray();

        List<List<Integer>> testListOfList = Arrays.asList(Arrays.asList(1000, 2000), Arrays.asList(-10, -20, -30));
        Integer[][] inputArr = new Integer[testListOfList.size()][];
        int iiii = 0;
        for (List<Integer> nestedList : testListOfList) {
            inputArr[iiii++] = nestedList.toArray(new Integer[nestedList.size()]);
        }
        int rowMax = inputArr.length;
        int colMax = inputArr[0].length;
        int sum = 0;

        int row = inputArr.length;
        int col = inputArr[1].length;

        System.out.println("Row= "+row + " |col="+col);
        System.out.println(testListOfList);

        String result = letters.stream().reduce("", (tmp, element) -> tmp + element);
        System.out.println(result);
        System.out.println(numbers.stream().reduce(0, (tmp, ele) -> tmp + ele, Integer::sum));

        int k = 0;
        for (int i=0; i<numbers.size();i++) {
            for (int j=i+1;j<numbers.size();j++) {
                System.out.println("K = " + k++);
                if (numbers.get(i) > numbers.get(j)) {
                    int temp = numbers.get(i);
                    numbers.set(i, numbers.get(j));
                    numbers.set(j, temp);
                }
            }
        }
        //System.out.println(numbers);
    }
    static abstract class MyAbstract {
        public abstract void sayHello();
    }
}

