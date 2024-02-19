package strings;

public class IsSubsequence {
	
	public static boolean isSubsequence(String sub, String s) {
		int i = 0, j = 0;
		while(i < sub.length() && j < s.length()) {
			if(sub.charAt(i) == s.charAt(j)) {
				i++;
				j++;
			}
			j++;
		}
		return i == sub.length();
	}
	
	public static void main(String[] args) {
		String s = "abc", t = "ahbgdc";
		boolean subsequence = isSubsequence(s, t);
		System.out.println(subsequence);
	}

}
