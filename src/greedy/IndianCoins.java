package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class IndianCoins {
	
	public static void main(String[] args) {
		Integer[] coins = {1,2,5,10,20,50,100,500,2000};
		
		Arrays.sort(coins, Comparator.reverseOrder());
		
		int change = 510;
		int numberOfCoins = 0;
		
		for(int i = 0; i < coins.length; i++) {
			while(change >= coins[i]) {
				System.out.println("Coin used : " + coins[i]);
				change = change - coins[i];
				numberOfCoins++;
			}
		}
		
		System.out.println("Number of coins used are : " + numberOfCoins);
	}

}
