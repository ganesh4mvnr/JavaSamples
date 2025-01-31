package test.dp;

public class LongIslandDFS {
    public static void main(String[] args) {
        char[][] inp = {
                {'1','1','1','0','0'},
                {'0','0','1','0','1'},
                {'0','0','1','0','1'},
                {'0','0','0','0','1'}};

        System.out.println("Num of islands: " + numIslands(inp));
    }

    static void dfs(char[][] grid, int r, int c, Result result) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c, result);
        result.len++;
        dfs(grid, r + 1, c, result);
        dfs(grid, r, c - 1, result);
        result.breadth++;
        dfs(grid, r, c + 1, result);
    }

    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        Result result = new Result(0, 0);

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c, result);
                    System.out.println("Length: " + result.len);
                    System.out.println("breadth: " + result.breadth);
                }
            }
        }


        return num_islands;
    }

    static class Result {
        int len;
        int breadth;
        public Result(int len, int b) {
            this.len = len;
            this.breadth = b;
        }
    }
}
