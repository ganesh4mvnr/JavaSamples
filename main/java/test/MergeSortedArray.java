package test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeSortedArray {
    public static void main(String[] args) {
        MergeSortedArray m1 = new MergeSortedArray();
        int[] n1 = {0};
        int[] n2 = {1};
        int m = 0, n = 1;
        m1.merge(n1, m, n2, n);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        if (m > 0 && n > 0) {
            for (int i=0, j=m; i < n; i++, j++) {
                nums1[j] = nums2[i];
            }
        } else if (m == 0) {
            System.out.print("nums2 = ");
            Arrays.stream(nums2).forEach(System.out::println);
            nums1 = nums2;
            System.out.print("nums1 => ");
            Arrays.stream(nums1).forEach(System.out::println);
        }
        nums1 = new int[]{1};
        List<Integer> list = Arrays.stream(nums1).sorted().boxed().collect(Collectors.toList());
        System.out.println("Sorted array: " + list);
    }

    public static void sortNumberArrays(int[] arr) {
        int len = arr.length;
        int tmp = 0;
        for (int i=0; i < len; i++) {
            for (int j=0; j < len; j++) {
                if (arr[i] < arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}