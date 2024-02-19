package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagram {
	public static boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			map.put(charAt, map.getOrDefault(charAt, 0) + 1);
		}

		for (int i = 0; i < t.length(); i++) {
			char charAt = t.charAt(i);
			if (map.get(charAt) == 1) {
				map.remove(charAt);
			} else if (map.get(charAt) > 1) {
				map.put(charAt, map.get(charAt) - 1);
			} else {
				return false;
			}
		}

		return map.isEmpty();
	}

	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();
		
		for(int i = 0; i < strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String sortedWord = new String(charArray);
			
			if(!map.containsKey(sortedWord)) {
				map.put(sortedWord, new ArrayList<>());
			}
			map.get(sortedWord).add(strs[i]);
		}
		
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String s = "heart";
		String t = "eart";

		System.out.println(isAnagram(s, t));
		
		String[] strs = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> groupAnagrams = groupAnagrams(strs);
		for(List<String> l : groupAnagrams) {
			System.out.println(l);
		}
	}

}
