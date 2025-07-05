import java.util.HashMap;

public class twosum {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> num = new HashMap<>();
       for(int i = 0; i< nums.length; i++) {
            int diff = target - nums[i];
            if (num.containsKey(diff)) {
                return new int[] {num.get(diff), i};
            }
            num.put(nums[i], i);
        }
        return new int[] {}; // Return an empty array if no solution is found
    }

    public static void main(String[] args) {
        twosum solution = new twosum();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
