package test.dsa;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] argv) {
        String badgeRecords1[][] = new String[][]{{"Martha", "exit"}, {"Paul", "enter"}, {"Martha", "enter"},
                {"Steve", "enter"}, {"Martha", "exit"}, {"Jennifer", "enter"}, {"Paul", "enter"}, {"Curtis", "exit"},
                {"Curtis", "enter"}, {"Paul", "exit"}, {"Martha", "enter"}, {"Martha", "exit"}, {"Jennifer", "exit"},
                {"Paul", "enter"}, {"Paul", "enter"}, {"Martha", "exit"}, {"Paul", "enter"}, {"Paul", "enter"},
                {"Paul", "exit"}, {"Paul", "exit"}};
        // Expected output: ["Paul", "Curtis", "Steve"], ["Martha", "Curtis", "Paul"]

        String badgeRecords2[][] = new String[][]{{"Paul", "enter"}, {"Paul", "exit"},};
        // Expected output: [], []

        String badgeRecords3[][] = new String[][]{{"Paul", "enter"}, {"Paul", "enter"}, {"Paul", "exit"},
                {"Paul", "exit"},};
        // Expected output: ["Paul"], ["Paul"]

        String badgeRecords4[][] = new String[][]{{"Paul", "enter"}, {"Paul", "exit"}, {"Paul", "exit"},
                {"Paul", "enter"},};
        // Expected output: ["Paul"], ["Paul"]

        String[][] badgeRecords5 = new String[][]{{"Martha", "exit"}, {"Paul", "enter"}, {"Martha", "enter"},
                {"Martha", "exit"}, {"Jennifer", "enter"}, {"Paul", "enter"}, {"Curtis", "exit"}, {"Curtis", "enter"},
                {"Paul", "exit"}, {"Martha", "enter"}, {"Martha", "exit"}, {"Jennifer", "exit"}, {"Paul", "enter"},
                {"Paul", "enter"}, {"Martha", "exit"}};
        // Expected output: ["Curtis", "Paul"], ["Martha", "Curtis"]

        String[][] badgeRecords6 = new String[][]{{"Paul", "enter"}, {"Paul", "enter"}, {"Paul", "exit"}};
        // Expected output: ["Paul"], []

        String[][] badgeRecords7 = new String[][]{{"Paul", "enter"}, {"Paul", "exit"}, {"Paul", "exit"}};
        // Expected output: [], ["Paul"]

        String[][] badgeRecords8 = new String[][]{{"Paul", "enter"}, {"Paul", "exit"}, {"Paul", "exit"},
                {"Paul", "enter"}, {"Martha", "enter"}, {"Martha", "exit"}};
        // Expected output: ["Paul"], ["Paul"]

        List<Set<String>> lists = getInvalidEntryExit(badgeRecords1);

        lists.get(0).stream().forEach(System.out::println);
        System.out.println("---");
        lists.get(1).stream().forEach(System.out::println);
    }

    private static List<Set<String>> getInvalidEntryExit(String badgeRecords[][]) {

        Map<String, Stack<String>> map = new HashMap<>();
        Set<String> invalidExits = new HashSet<>();
        Set<String> invalidEntries = new HashSet<>();

        for (String[] record : badgeRecords) {

            // If map contains the name
            if (map.containsKey(record[0])) {
                Stack<String> stack = map.get(record[0]);

                // When record is "exit"
                if (record[1].equals("exit")) {
                    // If stack is empty
                    if (stack.isEmpty())
                        invalidExits.add(record[0]);
                        // If stack is not empty
                    else stack.pop();
                }
                // When record is "enter"
                else {
                    // If stack is not empty
                    if (!stack.isEmpty())
                        invalidEntries.add(record[0]);
                        // If stack is empty
                    else {
                        stack.push("enter");
                        map.put(record[0], stack);
                    }
                }
                // If user is not present in the map
            } else {
                // When record is "exit"
                if (record[1].equals("exit"))
                    invalidExits.add(record[0]);
                    // When record is "enter"
                else {
                    Stack<String> stack = new Stack<>();
                    stack.push(record[1]);
                    map.put(record[0], stack);
                }
            }
        }

        for (Map.Entry<String, Stack<String>> entry : map.entrySet()) {
            if (!entry.getValue().isEmpty())
                invalidEntries.add(entry.getKey());
        }

        List<Set<String>> result = new ArrayList<>();
        result.add(invalidExits);
        result.add(invalidEntries);

        return result;
    }
}