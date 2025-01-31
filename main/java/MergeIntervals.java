import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<int[]> merged = new LinkedList<>();
        for (int[] interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast()[1] + 1 < interval[0]) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] interval = {
                //{1, 4}, {5, 9}, {11, 20}
                {1, 5}, {4, 6}, {9,11},{15,18},{2,4},{16, 17}
        };
        int[][] output = merge(interval);
        Integer test;
        Arrays.stream(output).forEach(ints -> {
            System.out.print("\n");
            Arrays.stream(ints).forEach(MergeIntervals::accept);
        });
    }

    private static void accept(int i) {
        System.out.print(i + ", ");
    }
}