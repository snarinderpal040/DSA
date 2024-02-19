package leetcode;

public class ValidPerfectSquare367 {

	public static boolean isPerfectSquare(int num) {
		long low = 1;
		long high = num;
		
		while(low <= high) {
			long mid = low + (high - low) / 2;
			long sqrt = mid * mid;
			
			if(sqrt == num) {
				return true;
			} else if(sqrt < num) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		int num = 15;
		System.out.println(isPerfectSquare(num));
	}

}
