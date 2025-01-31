package test.dsa;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestLongestCommonSeq {
    public static void main(String[] args) {
        int A[] = { 1, 2, 4, 6, 7 };
        int B[] = { 3, 4, 5, 7 };

        System.out.println("\nMax LCS: " + getLCS(A, B));

        System.out.println("Max LCS from another: " + FindMaxLength(A, B, A.length, B.length));
    }

    public static int getLCS(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int[][] resultArr = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            resultArr[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            resultArr[0][j] = 0;
        }

        for (int i=1; i < n + 1; i++) {
            for (int j=1; j < m + 1; j++) {
                System.out.println("Value arr1_i[" + (i-1) +"]=" + arr1[i-1]);
                System.out.println("Value arr2_j[" + (j-1) +"]=" + arr2[j-1]);
                if (arr1[i-1] == arr2[j-1]) {
                    resultArr[i][j] = 1 + resultArr[i-1][j-1];
                } else {
                    resultArr[i][j] = Math.max(resultArr[i-1][j], resultArr[i][j-1]);
                }
            }
        }
        int max = 0;
        for (int i=0; i < n+1; i++) {
            for (int j = 0; j < m+1; j++) {
                max = Math.max(max, resultArr[i][j]);
            }
        }

        List<int[]> lists = Arrays.asList(resultArr);
        lists.forEach(ints -> {
            Arrays.stream(ints).forEach(a -> System.out.print(a + ","));
        });

        return max;
    }

    static int FindMaxLength(int A[], int B[], int n, int m)
    {

        // Auxiliary dp[][] array
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = 0;

        // Updating the dp[][] table
        // in Bottom Up approach
        for (int i = n - 1; i >= 0; i--)
        {
            for (int j = m - 1; j >= 0; j--)
            {
                // If A[i] is equal to B[i]
                // then dp[j][i] = dp[j + 1][i + 1] + 1
                if (A[i] == B[j])
                    dp[j][i] = dp[j][i] + 1;
            }
        }
        int maxm = 0;

        // Find maximum of all the values
        // in dp[][] array to get the
        // maximum length
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                // Update the length
                maxm = Math.max(maxm, dp[i][j]);
            }
        }

        // Return the maximum length
        return maxm;
    }
}
