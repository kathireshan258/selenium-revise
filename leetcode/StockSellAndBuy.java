package leetcode;

/**
 * Best Time to Buy and Sell Stock (LeetCode 121)
 * Given an array: prices = [7,1,5,3,6,4]
 * Each number represents the stock price on a day.
 * Rules:
 * Buy once
 * Sell once
 * Buy must happen before sell
 *
 * Goal:
     * Find maximum possible profit
 *
 * Example:
 * Buy at 1
 * Sell at 6
 *
 * Profit = 5
 *
 * Return:
 * 5
 * */

class StockSellAndBuy {
    static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7,1,5,3,6,4}));
    }

    static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            int profit = price - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
