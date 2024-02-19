package leetcode;

public class BuyOrSellStock {
	
	public static int maxProfit(int[] prices) {
		int sell = 0;
		int buy = prices[0];
		int mprofit = 0;
		
		for(int i = 1; i < prices.length; i++) {
			buy = Math.min(buy, prices[i - 1]);
			sell = prices[i];
			mprofit = Math.max(mprofit, sell - buy);
		}
		
		return mprofit;
	}
	
	
	public static void main(String[] args) {
		int[] prices = {7,1,5,3,6,4};
		
		System.out.println(maxProfit(prices));
	}

}
