package test.dsa;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargestNumber {
    public static void main(String[] args) {
        int[] inum = {3, 9, 8, 4, 6, 1, 3, 9}; // 1,3,4,6,8,9
        System.out.println("4th largest num: " + findKthLargest(inum, 4));
    }
    public static int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>(Comparator.comparingInt(n -> n));

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        System.out.println("heap: " + heap);
        // output
        return heap.poll();
    }
}
