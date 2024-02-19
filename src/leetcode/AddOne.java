package leetcode;

public class AddOne {
	public static int[] plusOne(int[] digits) {

		int n = digits.length;

		for (int i = n - 1; i >= 0; i--) {
			if (digits[i] == 9) {
				digits[i] = 0;
			} else {
				digits[i] = digits[i] + 1;
				return digits;
			}
		}
		
		digits = new int[n + 1];
		digits[0] = 1;
		return digits;

	}

	public static void main(String[] args) {
		int[] digits = { 9,9,9,9 };
		int[] plusOne = plusOne(digits);
		for (int i : plusOne) {
			System.out.print(i + " ");
		}
	}
}
