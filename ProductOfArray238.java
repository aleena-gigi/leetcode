public class ProductOfArray238 {
    /*
    * Time complexity: O(n)
    * space compelxity: O(1) since the space for result is a constant n
    */
    public int[] productExceptSelf(int[] nums) {
        // calculate teh product expect the current position
        int n = nums.length;
        int[] result = new int[n]; //space: O(1)

        // calculate the left products
        result[0] = 1; 
        for (int i = 1; i < n; i++) { //time: O(n)
            result[i] = result[i-1] * nums[i-1];
        }

        // Calculate the right product
        int rightProduct = 1; //space: O(1)
        for(int i = n-1; i >= 0 ; i--) { //time: O(n)
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return result;
    }
// [2,3,4,5]
// first pass result = [1,2,6,24]
// second pass
// i=3 result = [1,2,6,24 * 1] rightproduct=1*5
// i=2 [1,2,6*5,24 ] rightproduct=5*4
// i=1 [1,2*20,30,24] rightproduct=20*3
// i=0 [1*60,40,30,24] rightproduct=60* 1
    public static void main(String[] args) {
        ProductOfArray238 solution = new ProductOfArray238();
        int[] nums = {2,3,4,5};
        int[] result = solution.productExceptSelf(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
