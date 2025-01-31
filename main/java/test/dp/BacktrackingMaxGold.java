package test.dp;

/**
 * {1,0,7},
 * {2,0,2},
 * {0,1,5},
 * {0,1,0},
 * {2,0,1}
 */
public class BacktrackingMaxGold {
    public static void main(String[] args) {
        int[][] grid = {{0,1,5},{0,1,0},{2,0,1}};
        System.out.println("MaxGold: " + getMaximumGold(grid));
    }
    public static int getMaximumGold(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;
        for (int i=0; i < m;i++) {
            for (int j=0; j < n; j++) {
                grid[0][j] = 0;
                grid[i][0] = 0;
            }
        }
        for (int r = m-1; r >= 0; r--) {
            for (int c = 0; c < n; c++) {
                maxGold = Math.max(maxGold, findMaxGold(grid, m, n, r, c));
            }
        }
        return maxGold;
    }

    static int findMaxGold(int[][] grid, int m, int n, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0)    return 0;
        int origin = grid[r][c];
        grid[r][c] = 0;
        int maxGold = 0;
        maxGold = Math.max(maxGold, Math.max(findMaxGold(grid, m, n, r-1, c), findMaxGold(grid, m, n, r, c+1)));
        grid[r][c] = origin;
        return maxGold + origin;
    }
}