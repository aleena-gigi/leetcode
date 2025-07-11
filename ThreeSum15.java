import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;

        for(int i = 0; i < n-2 ; i++)   {   //used to fix the first item
            int l = i + 1;
            int r = n - 1;
            if (i > 0 && nums[i] == nums[i-1]) continue; // dont have to find another triplet of the duplicate of the first element since we have already added it to results
            while (l<r)  {// find all possible (j,k) = - i
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    // add it to the array and move left and right inwards to find other possible combination
                    results.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //  before moving inwards , we should skip all the duplicate elements such that current value != next value, since otherwise we would add same triplet to the array again
                    while (l < r  && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--; // this helps us get a position of right where the next right is not a duplicate, that way we could iterate to the next element without the concern of taking a duplicate value of the current 
                    l++;    //after skipping all the duplicates of the current left, we move to the next different value of left
                    r--;
                } else if (sum < 0) {   // move left inwards to increase the sum to get it close to 0
                    l++;
                } else {    // we need to decrease the sum, right inwards to get sum close to  0
                    r--;
                }
            }

        }

        return results;
    }

    public static void main(String[] args) {
        ThreeSum15 ob = new ThreeSum15();
        int[] nums = {-4, -1, -1, 0, 2, 2};
        System.out.println(ob.threeSum(nums));
    }
}


/*
 * Algorithm:
 * 1. Sort the array.
 * 2. Iterate through the array, fixing one element at a time.
 *      2.1 Use two pointers (left and right) to find pairs that sum to the negative of the fixed element.
 *      2.2 if i > 0 and nums[i] == nums[i-1], continue to avoid duplicates. (since we have already added the triplet with the same first element)
 *      2.3 while (l < r): this is to find all possible pairs (j, k) such that nums[i] + nums[j] + nums[k] = 0
 *        2.3.1 Calculate the sum of the fixed element, left pointer, and right pointer.
 *        2.3.2 If the sum is zero
 *          2.3.2.1 add the triplet to the results
 *          2.3.2.2 Skip duplicates for the left pointer and right pointer to avoid adding the same triplet again. this helps us get to the last duplicate value of the current left and right pointers. so we can move to the next different value of left and right pointers.
 *          2.3.2.3 Move the left pointer to the right and the right pointer to the left.
 *        2.3.3 If the sum is less than zero, move the left pointer to the right to increase the sum to get close to sum = 0.
 *        2.3.4 If the sum is greater than zero, move the right pointer to the left to decrease the sum.
 * 3. Return the list of triplets.
 */

 
/*
 * Time Complexity: O(n^2)
 Arrays.sort(): O(n log n)
for(int i = 0; i < n-2; i++) {        // Outer loop: runs n-2 times => O(n)
    while (l < r) {                   // Inner while: O(n) in worst case 
        // this loops can run a max of n times, you either increase left or decrease right pointer
        //  so inner loop runs at most n times for each i
    }
}
    total : outerloop * innerloop = O(n) * O(n) = O(n^2)
    O(n log n) + O(n^2) = O(n^2) // Dominant term is O(n^2)


* Space Complexity: O(1) for the two pointers and O(k) for the result
 i,l,r,sum -> O(1) space
 sorting: O(lon n) space(for recursion stack)
 result: O(k), not counted as its the required output
 overall : O(1) if we dont count sorting space, otherwise O(log n) if we count sorting space
 */