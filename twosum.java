import java.util.HashMap;

public class twosum {
    /*
     * Time complexity: O(n)
     * Space complexity: O(n)
     */
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> num = new HashMap<>(); // worst case store all n elements, space complexity: O(n)
       for(int i = 0; i< nums.length; i++) {  // Time complexity: O(n)
            int diff = target - nums[i];
            if (num.containsKey(diff)) { // O(1) average time complexity for HashMap lookup
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
