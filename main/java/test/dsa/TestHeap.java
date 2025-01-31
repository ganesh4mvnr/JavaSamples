package test.dsa;

import java.util.Arrays;
import java.util.stream.Collectors;

public class TestHeap {
    static int c = 1;
    public static void main(String[] args) {
        int arr[] = {4,10,25,12,13,23,20,34};
        sort(arr);
        System.out.println("Result of sorted array :");
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (largest != i) {
            int tmp = arr[largest];
            arr[largest] = arr[i];
            arr[i] = tmp;
            heapify(arr, n, largest);
        }
        System.out.println(c + " times called.");
        c++;
    }

    public static void sort(int[] numbers) {
        int n = numbers.length;

        // The last possible parent node (last non-leaf node) is found at (n / 2) - 1.
        // Hence, we start from n/2-1 node, here '1' is the last non-leaf node
        for (int i=n/2-1;i >= 0; i--) {
            heapify(numbers, n, i);
        }
        System.out.println("After half heapify");

        Arrays.stream(numbers).forEach(System.out::println);
        Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int i=n-1; i > 0; i--) {
            int tmp = numbers[0];
            numbers[0] = numbers[i];
            numbers[i] = tmp;

            heapify(numbers, i-1, 0);
        }

        System.out.println("After full heapify");
        Arrays.stream(numbers).forEach(System.out::println);
    }
}