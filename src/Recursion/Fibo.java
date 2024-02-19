package Recursion;

public class Fibo {
	public static int fibo(int n) {
		if (n == 0 || n == 1) {
			return 0;
		}
		if(n == 2) {
			return 1;
		}

		return fibo(n - 1) + fibo(n - 2);
	}

	public static void fiboOfN(int n, int first, int second) {
		if(n == 0) {
			return;
		}
		int sum = first + second;
		System.out.println(sum);
		fiboOfN(n-1, second, sum);
	}

	public static void main(String[] args) {
		System.out.println(fibo(5));
		int nth = 5;
		int first = 0;
		int second = 1;
		System.out.println(first);
		System.out.println(second);
		fiboOfN(nth-2, first, second);
	}

}
