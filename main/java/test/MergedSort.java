package test;

import java.util.Arrays;

public class MergedSort {
    public static void main(String[] args) {
        int[] nums1 = {1,2,0,0,1,5};
        int[] nums2 = {2,3,4};
        MergedSort ms = new MergedSort();
        ms.merge(nums1, 3, nums2, 3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("m = " + m);
        System.out.println("n = " + n);
        int len = m+n;
        int[] mergedNums = new int[len];
        if (m > 0 && n > 0) {
            int mIndex = m;
            int tmp = 0;
            for (int i=0; i < m; i++) {
                for (int j=0;j<n;j++) {
                    if (nums1[i] != 0 && nums1[i] > nums2[j]) {
                        tmp = nums1[i];
                        nums1[i] = nums2[j];
                        nums1[mIndex++] = tmp;
                    }
                }
            }
        } else if (m == 0) {
            System.out.print("nums2 = ");
            Arrays.stream(nums2).forEach(System.out::println);
            nums1 = nums2;
            System.out.print("nums1 => ");
            Arrays.stream(nums1).forEach(System.out::println);
        }

        sortNumberArrays(nums1);

        Arrays.stream(nums1).forEach(System.out::println);
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