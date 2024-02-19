package leetcode;

public class LetterCombination {
	
	public static void letterCombination(String[] keypad, String input, String ans) {
		if(input.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		String letters = keypad[input.charAt(0) - 48];

		for (int i = 0; i < letters.length(); i++) {
			letterCombination(keypad, input.substring(1), ans + letters.charAt(i));
		}

	}
	
	public static void main(String[] args) {
		String[] keypad = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		letterCombination(keypad, "567", "");
	}

}
