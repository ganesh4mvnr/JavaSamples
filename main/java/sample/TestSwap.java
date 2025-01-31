package sample;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestSwap {
    public static void main(String[] args) {
        int[] a = {10, 8};
        List<Integer> bb = List.of(10, 90/3, 1/9);

        int total = bb.stream().collect(Collectors.summingInt(Integer::intValue));
        System.out.println("total = " + total);

        System.out.println("Before swap... ");
        Arrays.stream(a).forEach(i -> System.out.println(i));
        swap(a);
        System.out.println("After swap... ");
        Arrays.stream(a).forEach(i -> System.out.println(i));
    }

    public static void swap(int arr[]) {
        arr[0] = Arrays.stream(arr).sum();
        arr[1] = arr[0] - arr[1];
        arr[0] = arr[0] - arr[1];
    }
}
