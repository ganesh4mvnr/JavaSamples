package test.dp;

import java.util.*;

public class FindMaxBox {
    public static void main(String[] argv) {
        int[][] image1 = {
                {0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 0, 0, 0, 1},
                {1, 0, 1, 0, 0, 0, 1},
                {1, 0, 1, 1, 1, 1, 1},
                {1, 0, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 1, 1, 1, 0},
        };

        int[][] image2 = {
                {0},
        };

        int[][] image3 = {
                {1},
        };

        int[][] image4 = {
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
        };

        FindMaxBox s = new FindMaxBox();
        int[][] response = s.findBoxes(image4);
        Arrays.stream(response).forEach(e -> Arrays.stream(e).forEach(System.out::print));
    }

    public int[][] findBoxes(int[][] input) {
        int rowLen = input.length;
        int colmLen = input[0].length;
        List<List<Integer>> result = new ArrayList<>();

        if (colmLen == 1) {
            if (input[0][0] == 0) {
                int[][] temp = new int[1][1];
                temp[0][0] = 0;
                return temp;
            } else {
                return result.toArray(new int[colmLen][]);
            }
        }

        for (int r=0;r < rowLen; r++) {
            for (int c=0;c < colmLen; c++) {
                if (input[r][c] == 0) {
                    result.add(Arrays.asList(r, c));
                    dfs(input, r, c);
                }
            }
        }

        return result.toArray(new int[colmLen][]);
    }

    public void dfs(int[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 1) {
            return;
        }

        grid[r][c] = -1;
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
