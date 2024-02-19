package Recursion;

public class ReverseAString {
	public static void reverse(String s) {
		if(s.length() == 0) {
			return;
		}
		System.out.print(s.charAt(s.length()-1));
		reverse(s.substring(0, s.length()-1));
	}

	public static void main(String[] args) {
		reverse("harman");
	}

}
