package leetcode;

public class LongestPalindrome {
	
	static int max = 0;
	static int start = 0;
	
	public static String longestPalindrome(String s) {
        if(s.length() < 2) {
        	return s;
        }
        
        char[] charArray = s.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
        	//when the substring can be of odd length
        	findPlaindrome(charArray, i, i);
        	
        	//when the substring is of the even length
        	findPlaindrome(charArray, i, i + 1);
        }
        
        return s.substring(start, start + max);
    }
	
	public static void findPlaindrome(char[] charArray, int s, int e) {
		while(s >= 0 && e < charArray.length && charArray[s] == charArray[e]) {
			s--;
			e++;
		}
		
		if(max < (e - s - 1)) {
			max = e - s - 1;
			
			//increase the s by one because when it came of of the loop we have already decreased it by one and need to increase by 1 now.
			start = s + 1;
		}
	}
	
	
	public static void main(String[] args) {
		String s = "aaaa";
		
		System.out.println(longestPalindrome(s));
	}

}
