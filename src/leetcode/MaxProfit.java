package leetcode;

public class MaxProfit {

	public static int maxProfit(int[] prices) {
		
		int buy = Integer.MAX_VALUE;
		int sell = 0;
		
		for (int i = 0; i < prices.length; i++) {
			buy = Math.min(buy, prices[i]);
			sell = Math.max(sell, prices[i] - buy);
		}
		
		return sell;
	}

	public static void main(String[] args) {
		int[] prices = { 7, 1, 5, 3, 6, 4 };

		int maxProfit = maxProfit(prices);
		System.out.println(maxProfit);
	}
}
