package game;

public class TicTacToe {
    public static void main(String[] args) {
        int[][] input = {{0,0},{2,0},{1,1},{2,1},{2,2},{0,1},{3,3}};
        String res = playTicTacToe(input);

        System.out.println("Result = " + res);
    }

    public static String playTicTacToe(int[][] moves) {

        int diag = 0, anti_diag = 0;
        int player = 1;
        int n = 4;
        int rows[] = new int[n];
        int cols[] = new int[n];

        int row = 0;
        int col = 0;
        for (int[] move : moves) {
            row = move[0];
            col = move[1];

            rows[row] += player;
            cols[col] += player;

            if (row == col) {
                diag += player;
            }
            if (row + col == n -1) {
                anti_diag += player;
            }

            if (Math.abs(rows[row]) == n || Math.abs(cols[col]) == n
                    || Math.abs(diag) == n || Math.abs(anti_diag) == n) {
                return (player == 1) ? "A" : "B";
            }

            player *= -1;
        }

        return "DRAW";
    }
}
