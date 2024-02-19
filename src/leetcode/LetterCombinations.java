package leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {
	
	public List<String> list = new ArrayList<>();
	
	String[] keypad = { " ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	
	public void solution(String digits, int idx, String newString) {
		if(idx == digits.length()) {
			list.add(newString);
			return;
		}
		
		String keysMapping = keypad[digits.charAt(idx) - '0'];
		
		for(int i = 0; i < keysMapping.length(); i++) {
			char currChar = keysMapping.charAt(i);
			
			solution(digits, idx + 1, newString + currChar);
		}
	}
	
	public List<String> letterCombinations(String digits) {
		if(digits.length() == 0) {
			return list;
		}
		
		solution(digits, 0, "");
		
		return list;
	}
	
	public static void main(String[] args) {
		LetterCombinations lc = new LetterCombinations();
		List<String> letterCombinations = lc.letterCombinations("456");
		System.out.println(letterCombinations);
	}

}
