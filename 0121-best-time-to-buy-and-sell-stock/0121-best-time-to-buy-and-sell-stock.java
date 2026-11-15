class Solution {
    public int maxProfit(int[] prices) {
        int maxPrice = Integer.MAX_VALUE;
        int minProfit = 0;

        for(int price : prices){
            if(price < maxPrice){
                maxPrice = price;
            }
            if(price - maxPrice > minProfit){
                minProfit = price - maxPrice;
            }
        }
        return minProfit;
    }
}