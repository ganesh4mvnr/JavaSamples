package sample;

import java.util.*;

public class CharCount {
    public static void main(String[] args) {
        List<Character> l1 = List.of('c', 'a', 'a', 'c', 'b', 'a', 'b', 'c');
        List<Integer> integers = List.of(4, 3, 1, 3, 5, 4, 3, 4);
        CharCount charCount = new CharCount();
        Character res = charCount.findMaxOccurrence(l1);
        System.out.println("Character res = " + res);

        System.out.println("Integer res = " + charCount.findMaxOccurrence(integers));

        List<Integer> newL = new ArrayList<>();
        newL.add(10);
        int[] arr1 = newL.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("arr1 = " + arr1);

    }

    public <T> T findMaxOccurrence(List<T> elementsList) {
        Map<T, Integer> counterMap = new HashMap<>();

        for (int i=0; i < elementsList.size(); i++) {
            int count = counterMap.getOrDefault(elementsList.get(i), 0);
            if (count == 0) {
                counterMap.put(elementsList.get(i), 1);
            } else {
                counterMap.put(elementsList.get(i), ++count);
            }
        }
        int max = 0;
        Iterator<T> itr = counterMap.keySet().iterator();
        T resp = null;

        while (itr.hasNext()) {
            T key = itr.next();
            System.out.println("key = " + key);
            int count = counterMap.get(key);
            if (max < count) {
                max = count;
                resp = key;
            }
        }

        T result = counterMap.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).get();
        System.out.println("result == " + result);

        return resp;
    }
}
