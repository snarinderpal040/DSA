package backtracking;

public class Permutations {
	
	public static void permutations(String s, String perm) {
		if(s.length() == 0) {
			System.out.println(perm);
			return;
		}
		
		for(int i = 0; i < s.length(); i++) {
			permutations(s.substring(0, i) + s.substring(i + 1), perm + s.charAt(i));
		}
	}

	public static void main(String[] args) {
		String s = "abc";
		permutations(s, "");
	}

}
