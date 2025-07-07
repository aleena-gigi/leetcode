public class MaximumSubarray53 {

    // Time complexity: O(n)
    // Space complexity: O(1)
    public int maxSumOfSubArray(int[] nums) {
        int maxEndingHere = nums[0]; // Max sum of subarray ending at the current position
        int maxSumSoFar = nums[0]; // maximum sum found so far

        for(int i = 1; i < nums.length; i++) {
           maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
           maxSumSoFar = Math.max(maxSumSoFar, maxEndingHere);
        }
        return maxSumSoFar;
    }

    // This method returns the indices of the maximum subarray
    public int[] maxSumSubArray(int[] nums){
        int maxEndingHere = nums[0]; // Max sum of subarray ending at the current position
        int maxSumSoFar = nums[0]; // maximum sum found so far
        int startIndex = 0, endIndex= 0;
        int bestStartIndex = 0, bestEndIndex = 0;

        for(int i = 1; i < nums.length; i++) {
            int currentSum = nums[i] + maxEndingHere;
            if(currentSum < nums[i]) {  // this means current sum is dragging us down so new subarray should start here
                startIndex = i; // new subarray starts at i
                endIndex = i; // new subarray ends at i for now
                maxEndingHere = nums[i];
            } else {
                endIndex = i; // if new sum is greater than nums[i] then we extend the subarray
                maxEndingHere = currentSum;
            }

            // Update global maximum and its indices
            if (maxSumSoFar < maxEndingHere) {
                //  update the max sum and replace it with the current indices used to track the subarray
                maxSumSoFar = maxEndingHere;
                bestStartIndex = startIndex;
                bestEndIndex = endIndex;
            } 
        } 

       return new int[] {bestStartIndex, bestEndIndex};
    }

    public static void main(String[] args) {
        MaximumSubarray53 solution = new MaximumSubarray53();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = solution.maxSumOfSubArray(nums);
        System.out.println("Maximum subarray sum is: " + result); // Output should be 6
        int[] subArrayIndices = solution.maxSumSubArray(nums);
        System.out.println("Maximum subarray indices are: [" + subArrayIndices[0] + ", " + subArrayIndices[1] + "]");
    }
}

/*
 * nums = [-2,1,-3,4,-1,2,1,-5,4]
maxEndingHere = -2
maxSumSoFar = -2

iteration starts from 1
maxEndingHere = max(1, -2 + 1) = 1 
maxSumSoFar = max(1, -2) = 1 start fresh

maxEndingHere = max(-3, -3 + 1) = -2 
maxSumSoFar = max(1, -2) = 1 since adding to the sum of ending is greater we extend  [1,-3]

maxEndingHere = max(4, 4 + -2) = 4
maxSumSoFar = max(1, 4) = 4  since adding to the sum of ending is lower meanign it drags us down we extend start fresh  [4]

maxEndingHere = max(-1, -1 + 4) = 3
maxSumSoFar = max(4, 3) = 4 since adding to the sum of ending is greater we extend [4, -1]

maxEndingHere = max(2, 2 + 3) = 5
maxSumSoFar = max(4, 5) = 5 since adding to the sum of ending is greater we extend [4, -1, 2]

maxEndingHere = max(1, 1 + 5) = 6
maxSumSoFar = max(5, 6) = 6 since adding to the sum of ending is greater we extend [4, -1, 2, 1 ]

maxEndingHere = max(-5, -5 + 6) = 1
maxSumSoFar = max(6, -1) = 6 since adding to the sum of ending is lower, meaning it drags us down we dont extend  and start fresh[-5]

maxEndingHere = max(4, 4 + -5) = 4
maxSumSoFar = max(6, 4) = 6 since adding to the sum of ending is lower, meaning it drags us down we dont extend  and start fresh[4]

from the above we have max sum as 6 so it returns 6
 */