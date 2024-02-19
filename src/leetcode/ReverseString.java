package leetcode;

public class ReverseString {
	
	public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;
        
        while(end >= start) {
        	char curr = s[end];
        	s[end] = s[start];
        	s[start] = curr;
        	start++;
        	end--;
        }
    }
	
	public static void main(String[] args) {
		char[] s = {'h','e','l','l','o','o'};
		
		reverseString(s);
		System.out.println(s);
	}

}
