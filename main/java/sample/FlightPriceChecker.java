package sample;

import java.util.Stack;

public class FlightPriceChecker {
    public static int[] daysUntilCheaperFlight(int[] prices) {
        int n = prices.length;
        int[] result = new int[n]; // Initialize the result array with zeros
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of the indices of prices

        // Traverse the list from right to left
        for (int i = n - 1; i >= 0; i--) {
            // While stack is not empty and current price is less than or equal to the price at the top of the stack
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                stack.pop();
            }

            // If stack is not empty, the top element in the stack is the next day with a cheaper price
            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            } else {
                result[i] = 0; // No cheaper day found
            }

            // Push the current index to the stack
            stack.push(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] flights = {350, 200, 150, 120, 225, 415, 300, 500};
        int[] result = daysUntilCheaperFlight(flights);

        // Print the result
        for (int days : result) {
            System.out.print(days + " ");
        }
    }
}
