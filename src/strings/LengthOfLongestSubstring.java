package strings;

import java.util.HashMap;

public class LengthOfLongestSubstring {

	public static int lengthOfLongestSubstring(String s) {
		int left = 0, right = 0, maxLength = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		while(right < s.length()) {
			char currChar = s.charAt(right);
			map.put(currChar, map.getOrDefault(currChar, 0) + 1);
			
			while(map.get(currChar) > 1) {
				char leftChar = s.charAt(left);
				map.put(leftChar, map.get(leftChar) - 1);
				left++;
				maxLength = Math.max(maxLength, right - left + 1);
			}
			right++;
		}
		
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
