package leetcode;

import java.util.HashMap;

public class FindTheDifference389 {
	
	public static char findTheDifference(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(char c : s.toCharArray()) {
			if(map.get(c) > 1) {
				map.put(c, map.get(c) -1);
			}else {
				map.remove(c);
			}
		}
		
		return map.keySet().stream().findFirst().get();
		
	}
	
	public static void main(String[] args) {
		String s = "a", t = "aa";
		System.out.println(findTheDifference(s, t));
	}

}
