package test.dsa.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 4, 10, 5, 6}; // 0, 4, 10, 5, 22, 12, 7

        quickSort(arr, 0, arr.length-1);

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void quickSort(int[] inp, int left, int right) {
        int i = left;
        int j = right;
        int pivot = inp[(left+right)/2];

        System.out.println("quickSort is called");

        while (i <= j) {
            while (inp[i] < pivot) {
                i++;
            }
            while (inp[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int tmp = inp[i];
                inp[i] = inp[j];
                inp[j] = tmp;
                i++;
                j--;
            }
        }
        if (left < j) {
            quickSort(inp, left, j);
        }
        if (right > i) {
            quickSort(inp, i, right);
        }
    }
}
