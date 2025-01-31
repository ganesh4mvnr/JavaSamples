package test.dp;

import java.util.Arrays;

public class RottenOrange {
    public static void main(String[] args) {
        Orange[][] fruits = new Orange[4][4];
        int l = fruits.length;
        int h = fruits[0].length;
        int[][] directions = {
                {-1, 0}, {0, -1}, {0, 1}, {1, 0}
        };

        System.out.println("direction: " + directions[0][0]);

        for (int i = 0; i < l; i++) {
            for (int j=0; j < h; j++) {
                Orange o1 = new Orange(false, i, j);
                fruits[i][j] = o1;
            }
        }

        System.out.println("l = " + l);
        System.out.println("fruits[0][2] = " + fruits[0][2]);
        Arrays.stream(fruits).forEach(f -> Arrays.stream(f).forEach(System.out::println));


    }


}

class Orange {
    public boolean visited;
    public boolean rotten;
    public int x_pos;
    public int y_pos;
    public Orange(boolean rotten, int x, int y) {
        this.rotten = rotten;
        this.x_pos = x;
        this.y_pos = y;
    }
    public String toString() {
        return "position = " + x_pos+","+y_pos + " | visited = " + visited + " | rotten = " + rotten;
    }
}
