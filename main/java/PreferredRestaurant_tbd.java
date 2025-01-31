import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PreferredRestaurant_tbd {
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
                {{1, 2, 3, 4},
                {2, 1, 3, 4},
                {2, 4, 4, 4}};
        PreferredRestaurant_tbd p1 = new PreferredRestaurant_tbd();
        System.out.println("Choice1 of restaurant: " + p1.findPreferredRestuarant(preferences1));
        System.out.println("Choice2 of restaurant: " + p1.findPreferredRestuarant(preferences2));
        System.out.println("Choice3 of restaurant: " + p1.findPreferredRestuarant(preferences3));
    }

    public int findPreferredRestuarant(int[][] preferences) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Preference> preferenceMap = new HashMap<>();

        for (int r=0; r < preferences.length; r++) {
            for (int c=0; c < preferences[0].length; c++) {
                int choice = preferences[r][c];
                Preference pref = preferenceMap.getOrDefault(preferenceMap.get(choice), new Preference(1, 0, choice));
                int weightage = pref.weightage;
                countMap.put(choice, countMap.getOrDefault(choice, 0) + 1);
                weightage += ((preferences[0].length - c) * (preferences[0].length - c));
                pref.weightage = weightage;

                preferenceMap.put(choice, pref);
            }
        }

        System.out.println(preferenceMap);

        return preferenceMap.entrySet().stream().map(Map.Entry::getValue).max(
                Comparator.comparing(Preference::getChoice)).get().getChoice();
    }

    class Preference {
        public int count;
        public int weightage;

        public Integer getChoice() {
            return choice;
        }

        public void setChoice(Integer choice) {
            this.choice = choice;
        }

        public Integer choice;

        Preference(int c, int w, int ch) {
            this.count = c;
            this.weightage = w;
            this.choice = ch;
        }
    }
}
