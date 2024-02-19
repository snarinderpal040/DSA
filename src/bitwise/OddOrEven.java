package bitwise;

public class OddOrEven {
	public static void isEvenOrOdd(int num) {
		int bitmask = 1;
		
		if((num & bitmask) == 1) {
			System.out.println("Odd number");
		}else {
			System.out.println("Even number");
		}
	}
	
	public static void main(String[] args) {
		isEvenOrOdd(11);
		isEvenOrOdd(6);
		isEvenOrOdd(3);
	}

}
