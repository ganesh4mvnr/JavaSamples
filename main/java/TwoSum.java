import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSum {
    public static void main(String[] args) {
        TwoSum t1 = new TwoSum();
        int[] nums = {7,-2,3,6,11,2,-1,15};
        int res[] = t1.twoSum(nums, 5);
        Arrays.stream(res).forEach(System.out::println);
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] filteredNums = Arrays.stream(numbers).sorted().toArray();
        List<Integer> result = new ArrayList<>();

        int j = filteredNums.length - 1;
        for(int i=0; i < filteredNums.length && i < j;) {
            int total = filteredNums[i] + filteredNums[j];
            if (total == target) {
                result.add(filteredNums[i++]);
                result.add(filteredNums[j]);
            } else if (total < target) {
                i++;
            } else {
                j--;
            }
        }

        System.out.println("result ==> " + result);

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
