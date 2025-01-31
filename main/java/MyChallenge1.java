import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyChallenge1 {
    public static void main(String[] args) {
        int[] numbers = {24, 26, 29, 30, 34, 38, 40, 3, 4, 9};
        int[] num2 = new int[0];
        Map<Character, Character> charMap = Map.of(
                '{', '}',
                '[', ']',
                '(',')'
        );
        int index = findRotatedIndex(numbers);
        System.out.println("Rotated Index: " + index);
        System.out.println("Starting value: " + numbers[index]);

        int[] merged = numbers;

        System.out.println("Merged: ");
        Arrays.stream(merged).forEach(System.out::println);
    }

    static int findIndex(int[] numbers, int inp, int low, int high) {
        while (low <= high) {
            int pivot = (low + high) / 2;
            int mid = numbers[pivot];

            if (inp == numbers[pivot]) return pivot;

            if (inp < mid) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }


        return -1;
    }

    static int findRotatedIndex(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;

        if (numbers[low] < numbers[high]) return 0;

        while (low <= high) {
            int pivot = (low + high) / 2;

            if (numbers[pivot] > numbers[pivot + 1]) {
                return pivot + 1;
            }

            if ( numbers[pivot] < numbers[low]) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }


        return 0;
    }
}
