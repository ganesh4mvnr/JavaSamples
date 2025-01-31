package test.dsa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestParentChild {

    public static void main(String[] args) {
        int[][] parentChildPairs = new int[][] {
                {1, 3}, {2, 3}, {3, 6}, {5, 6}, {15, 9}, {5, 7},
                {4, 5}, {4, 8}, {4, 9}, {9, 11}
        };

        List<List<Integer>> list = findNodesWithZeroAndOneParents(parentChildPairs);

        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    static List<List<Integer>> findNodesWithZeroAndOneParents(int[][] parentChildPairs) {
        Set<Integer> zeroParentNodes = new HashSet<>();
        Set<Integer> oneParentNodes = new HashSet<>();
        Set<Integer> extraParentNodes = new HashSet<>();

        for (int[] parentChild : parentChildPairs) {
            int parent = parentChild[0];
            int child = parentChild[1];

            if (!oneParentNodes.contains(parent) && !extraParentNodes.contains(parent)) {
                zeroParentNodes.add(parent);
            }

            if (zeroParentNodes.contains(child)) {
                zeroParentNodes.remove(child);
                oneParentNodes.add(child);
            } else if (oneParentNodes.contains(child)) {
                oneParentNodes.remove(child);
                extraParentNodes.add(child);
            } else {
                oneParentNodes.add(child);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>(zeroParentNodes));
        result.add(new ArrayList<>(oneParentNodes));

        return result;
    }
}
