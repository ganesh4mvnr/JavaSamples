package test.dsa;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestMemoization {
    public static void main(String[] args) {
        TestMemoization m1 = new TestMemoization();
        System.out.println(m1.fib(66));
        //Arrays.stream(cache).forEach(System.out::println);

        Map<Integer, Integer> counter = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> elem = counter.entrySet();
    }

    public static long[] cache = new long[100];
    // 1, 1, 2, 3, 5, 8, 13
    public long fib(int num) {
        long res = 1;
        if (num == 0 || num == 1) return num;
        if (cache[num] != 0) {
            res = cache[num];
        } else if (num > 1) {
            System.out.println("num = " + num);
            res = fib(num - 1)  + fib(num - 2);
            cache[num] = res;
        }
        return res;
    }
}