package Recursion;

public class PrintNnumbers {
	public static void print(int n) {
		if(n == 0) {
			System.out.println(n);
			return;
		}
		print(n-1);
		System.out.println(n);
	}
	
	public static void reversePrint(int n) {
		if(n == 0) {
			System.out.println(n);
			return;
		}
		System.out.println(n);
		reversePrint(n-1);
	}

	public static void main(String[] args) {
		print(5);
		
		System.out.println();
		
		reversePrint(10);
	}

}
