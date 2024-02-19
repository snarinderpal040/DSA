package leetcode;

public class FirstUniqueChar {
	public static int firstUniqChar(String s) {
		
		for(int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			int indexOf = s.indexOf(currChar);
			int lastIndexOf = s.lastIndexOf(currChar);
			if(indexOf == lastIndexOf) {
				return indexOf;
			}
		}
        
		return -1;
    }
	

	public static void main(String[] args) {
		String s = "aabb";
		
		System.out.println(firstUniqChar(s));
	}

}
