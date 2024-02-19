package leetcode;

public class MaxNumberOfVowels1456 {
	
	private static boolean checkVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
	}

	public static int maxVowels(String s, int k) {
		int[] isVowel = new int[s.length()]; 
		int count = 0;
		for(char c : s.toCharArray()) 
			isVowel[count++] = checkVowel(c) ? 1 : 0 ;
		
		int max = 0;
		for(int i = 0; i < k; i++) 
			max += isVowel[i];
		
		int maxVowels = max;
		for(int i = k; i < isVowel.length; i++) {
			max += isVowel[i] - isVowel[i - k];
			maxVowels = Math.max(maxVowels, max);
		}
		return maxVowels;
	}

	public static void main(String[] args) {
		String s = "leetcode";
		int k = 3;
		System.out.println(maxVowels(s, k));
	}

}
