package leetcode;

public class GuessNumberHigherOrLower374 {
	
	public static int guessNumber(int n) {
		int low = 1;
		int high = n;
		
		while(low <= high) {
			int mid = low + (high - low)/2;
			if(guess(mid) > 0) {
				low = mid + 1;
			}
			if(guess(mid) < 0) {
				high = mid - 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	private static int guess(int n) {
		return 1;
	}

	public static void main(String[] args) {
		
	}

}
