import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PreferredRestaurant {
    public static void main(String[] args) {
        int[][] preferences1 =
                {{1, 2, 3, 4},
               {2, 1, 3, 4},
               {3, 2, 1, 4}};
        int[][] preferences2 =
                {{2, 2, 3},
                {3, 3, 2},
                {1, 1, 1}};
        int[][] preferences3 =
                {{1, 1, 3, 4},
                {2, 2, 3, 4},
                {2, 4, 4, 4}};
        PreferredRestaurant p1 = new PreferredRestaurant();
        System.out.println("Choice1 of restaurant: " + p1.findPreferredRestuarant(preferences1));
        System.out.println("Choice2 of restaurant: " + p1.findPreferredRestuarant(preferences2));
        System.out.println("Choice3 of restaurant: " + p1.findPreferredRestuarant(preferences3));
    }

    public int findPreferredRestuarant(int[][] preferences) {
        int[] count = new int[10];
        int[] weightage = new int[10];
        Map<Integer, Integer> preferencesMap = new HashMap<>();
        Calculate cal = (n, w) -> (n * n) + w;

        for (int r=0; r < preferences.length; r++) {
            for (int c=0; c < 3; c++) {
                int choice = preferences[r][c];
                count[choice]++;
                weightage[choice] = cal.weightage(3 - c, weightage[choice]);
                preferencesMap.put(choice, count[choice] + weightage[choice]);
            }
        }

        System.out.println(preferencesMap);

        return preferencesMap.entrySet().stream().max(
                Comparator.comparing(Map.Entry::getValue)).get().getKey();
    }

    @FunctionalInterface
    interface Calculate {
        int weightage(int num, int weight);
    }
}
