package Recursion;

import java.util.HashMap;
import java.util.HashSet;

public class SubSequences {
	static int idx = 1;

	public static void subSequences(String s, String sub) {
		if (s.length() == 0) {
			System.out.println(sub + " " + idx++);
			return;
		}

		subSequences(s.substring(1), sub + s.charAt(0));
		subSequences(s.substring(1), sub);
	}

	public static int lengthOfLongestSubstring(String s) {
		HashSet<String> set = new HashSet<>();
		int n = s.length();
		String s1 = "";

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (!set.contains(s1)) {
				set.add(s1);
			}
			if (!set.contains(s1 + c)) {
				s1 = s1 + c;
				set.add(s1);
			}
		}
		System.out.println(set);
		return s.length();
	}

	public static int lengthOfLongestSubstring1(String s) {
		int maxLength = 0;
		int n = s.length();

		for (int i = 0; i < n; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < n; j++) {
				if (sb.indexOf(String.valueOf(s.charAt(j))) != -1) {// means character exists in string builder
					break;
				}
				sb.append(s.charAt(j));
				maxLength = Math.max(maxLength, sb.length());
			}
		}

		return maxLength;
	}

	
	public static int lengthOfLongestWord(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		int length = s.length();
		int max = 0;
		
		for(int right = 0, left = 0; right < length; right++) {
			char currChar = s.charAt(right);
			
			if(map.containsKey(currChar) && map.get(currChar) >= left) {
				left = map.get(currChar) + 1;
			}
			
			max = Math.max(max, right - left + 1);
			map.put(currChar, right);
		}
		
		return max;
	}

	public static void main(String[] args) {
//		subSequences("abc", "");

		String s = "abcabcbb";

//		lengthOfLongestSubstring(s);

		
		System.out.println(lengthOfLongestWord(s));
	}
}
