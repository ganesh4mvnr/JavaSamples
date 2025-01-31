import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // Skip duplicates for the third number
//                    while (left < right && nums[right] == nums[right - 1]) {
//                        right--;
//                    }

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;  // We need a larger sum
                } else {
                    right--; // We need a smaller sum
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, -1, 0, -2, 2, 4};
        List<List<Integer>> triplets = threeSum(nums);
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }

        System.out.println("triplets = " + triplets);
    }
}
