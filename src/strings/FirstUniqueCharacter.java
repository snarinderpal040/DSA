package strings;

public class FirstUniqueCharacter {
	
	public static int firstNonRepeatingCharacter(String s) {
		
		for(char c : s.toCharArray()) {
			if(s.indexOf(c) == s.lastIndexOf(c)) {
				return s.indexOf(c);
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String s = "loveleetcode";
		System.out.println(firstNonRepeatingCharacter(s));
		
	}

}
