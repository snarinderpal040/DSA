package hashmap;

import java.util.HashMap;

public class IsValidAnagram {
	
	public static boolean isValid(String s1, String s2) {
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(char c : s1.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		for(char c: s2.toCharArray()) {
			if(map.containsKey(c)) {
				if(map.get(c) > 1) {
					map.put(c, map.get(c) - 1);
				}else {
					map.remove(c);
				}
			}else {
				return false;
			}
		}
		
		return map.isEmpty();
	}

	public static void main(String[] args) {
		String s1 = "tulip";
		String s2 = "lipid";	
		System.out.println(isValid(s1, s2) ? "Anagram" : "Not Anagram");
	}

}
