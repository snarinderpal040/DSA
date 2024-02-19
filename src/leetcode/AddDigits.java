package leetcode;

public class AddDigits {
	public static int add(int n) {
		int i = 0;
		
		while(n != 0) {
			i = i + (n % 10);
			n = n/10;
		}
		
		if(i >= 10) {
			return add(i);
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(add(65891));
	}
}
