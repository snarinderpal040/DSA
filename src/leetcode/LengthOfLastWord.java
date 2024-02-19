package leetcode;

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		String[] split = s.split(" ");
		
		return split[split.length - 1].length();
	}

	public static void main(String[] args) {
		String s = " Hello    My Name is Narinder       ";
		
		int lengthOfLastWord = lengthOfLastWord(s);
		System.out.println(lengthOfLastWord);	
	}
}
