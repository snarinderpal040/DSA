package leetcode;

public class ArrangingCoins441 {

	public static int arrangeCoins(int n) {
		if (n == 0 || n == 1) {
			return n;
		}

		int row = 0;
		int coinsToPlace = 1;

		while (n > 0) {
			if ((n - coinsToPlace) < 0) {
				break;
			} else {
				n = n - coinsToPlace;
				coinsToPlace += 1;
				row++;
			}
		}

		return row;
	}
	
	public static int arrangeCoinsII(int n) {
		long left = 0, right = n;
		long mid = 0;
		
		while(left <= right) {
			mid = left + (right - left) / 2;
			
			long res = mid * (mid + 1) / 2;
			
			if(res > n) {
				right = mid - 1;
			}else if (res < n) {
				left = mid + 1;
			}else {
				return (int) mid;
			}
		}

		return (int) right;
	}

	public static void main(String[] args) {
		int n = 100000000;
		System.out.println(arrangeCoins(n));
		
		System.out.println(arrangeCoinsII(n));

	}

}
