import java.util.HashSet;

public class ContainsDuplicate217 {
        /*
    * Space complexity
    * worst case: O(n)
    * avg case: O(k):  where k is the position of the first duplicate
    * Time complexity
    * worst case: O(n) , iterate through the entire array to find the duplicate
    * avg case: O(k), early termination on the first occurance of duplicate
    */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> uniqueValues = new HashSet<>(); // space: O(n)
        for(int i = 0; i < nums.length; i++) { //time: O(n)
            if(uniqueValues.contains(nums[i])) { //O(1)
                return true;
            } else {
                uniqueValues.add(nums[i]); //o(1)
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate217 solution = new ContainsDuplicate217();
        int[] nums = {1, 2, 3, 4, 5, 13};
        boolean result = solution.containsDuplicate(nums);
        System.out.println("Contains Duplicate: " + result);
        int[] nums2 = {1, 2, 3, 4, 5, 1};
        boolean result2 = solution.containsDuplicate(nums2);
        System.out.println("Contains Duplicate: " + result2);
    }
}
