package Recursion;


public class RemoveDuplicates {
	public static void remove(String s, String newString, boolean[] arr, int idx) {
		if(idx == s.length()) {
			System.out.println(newString);
			return;
		}
		char currChar = s.charAt(idx);
		if(arr[currChar - 'a']) {
			
		}else {
			newString += currChar;
			arr[currChar - 'a'] = true;
		}
		remove(s, newString, arr, idx+1);
	}

	public static void main(String[] args) {
		boolean[] arr = new boolean[26];
		
		remove("narinderpalsingh", "", arr, 0);
	}

}
