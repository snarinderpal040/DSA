package strings;

public class IsPalindrome {
	
	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		
		while(left <= right) {
			if(s.charAt(left) == s.charAt(right)) {
				left++; right--;
			}
			else {
				return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		String s = "bubabbdabub";
		System.out.println(isPalindrome(s));
	}

}
