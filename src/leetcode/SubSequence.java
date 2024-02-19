package leetcode;

import java.util.HashSet;

public class SubSequence {

	static HashSet<String> set = new HashSet<>();

	public static void allsubs(String s, String temp) {
		if (s.length() == 0) {
			set.add(temp);
			return;
		}

		char currChar = s.charAt(0);

		allsubs(s.substring(1), temp+currChar);

		allsubs(s.substring(1), temp);
		
	}

	public static boolean isSubsequence(String s, String t) {
		if (s.length() == 0 && t.length() == 0) {
			return true;
		}
		if (s.length() == 0 && t.length() != 0) {
			return true;
		}
		if(s.length() == t.length() && s.equalsIgnoreCase(t)) {
			return true;
		}
		allsubs(t, "");
		if (set.contains(s)) {
			return true;
		}

		return false;
	}
	
	public static boolean isSub(String s, String t) {
		int i = 0;
		int j = 0;
		
		while(i < s.length() && j < t.length()) {
			if(s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		
		
		return i == s.length();
	}

	public static void main(String[] args) {
		System.out.println(isSub("nar", "narinder"));
	}

}
