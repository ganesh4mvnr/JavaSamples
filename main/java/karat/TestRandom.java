package karat;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

public class TestRandom {
    public static void main(String[] args) {
        int[] arr = {87, 19, 23, 4, 1};
        int len = arr.length;
        int random = new Random().nextInt(len);
        System.out.println("Random= " + random + " from arr: " + arr[random]);
        random = new Random().nextInt(len);
        System.out.println("Next Random= " + random + " from arr: " + arr[random]);

        Stack<Integer> integerStack = new Stack<>();
        integerStack.setSize(1);
        Arrays.stream(arr).forEach(i -> integerStack.push(i));

        System.out.println("integerStack == " + integerStack);
    }
}
