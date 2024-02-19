package leetcode;

import java.util.HashMap;

public class StringCompression443 {
	
	public static int compress(char[] chars) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(char c : chars) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for(Character c : map.keySet()) {
			if(map.get(c) == 1) {
				sb.append(c);
			}else {
				sb.append(c);
				System.out.println(map.get(c));
				sb.append(map.get(c));
			}
		}
		System.out.println(sb);
		return sb.toString().length();
    }

	public static void main(String[] args) {
		char[] chars = {'a', 'a', 'b', 'b', 'c', 'c','c'};
		
		System.out.println(compress(chars));
	}

}
