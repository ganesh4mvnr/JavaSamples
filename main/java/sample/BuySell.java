package sample;

import java.util.Arrays;

public class BuySell {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 3, 9, 2, 8};
        int max = maxProfit(arr);
        Arrays.stream(arr).forEach(e -> System.out.println(e));
        System.out.println("max = " + max);
    }

    public static int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            }

            profit = Math.max(profit, prices[i] - buyPrice);
        }

        return profit;
    }
}
