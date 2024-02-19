package leetcode;

public class StringReverseUptoSomeLength {

	public static String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();

		if (k >= s.length()) {
			sb = sb.append(s).reverse();
			return sb.toString();
		}
		else if(s.length() >= 2*k) {
			StringBuilder temp = new StringBuilder();
			temp.append(s.substring(0, k)).reverse();
			return temp.toString() +"" +s.substring(k, 2*k) +"" + reverseStr(s.substring(k * 2), k);
		}else {
			StringBuilder temp = new StringBuilder();
			temp.append(s.substring(0, k)).reverse();
			return temp.toString() + "" + s.substring(k);
		}

	}

	public static void main(String[] args) {
		String reverseStr = reverseStr("abcdefghijklmno", 2);
		System.out.println(reverseStr);
	}

}
