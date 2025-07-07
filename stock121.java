public class stock121 {
    /* Input : prices[n] this is given to us we dont create it, so we dont count input space for space complexity, but the space for this is O(n)
    * Extra space we created: minPrice, maxProfit, currentPRoft which is all O(1)
    * Time complexity: O(n)
    * Space complexity: O(1)
    */
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxPrice = 0;
        for(int i = 0 ; i < prices.length ; i++) { // TimeComplexity: O(n)
            if ( minPrice  > prices[i]) {
                minPrice = prices[i];
            } else {
                int currentProfit = prices[i] - minPrice;
                if (maxPrice < currentProfit) {
                    maxPrice = currentProfit;
                }
            }
        }
        return maxPrice;
    }
    public static void main(String args[]) {
        int[] prices = new int[]{2,4,2,3,1};
        stock121 ob = new stock121();
        System.out.println(ob.maxProfit(prices));
    }
}
