package bitwise;

public class Set {
	public static int setIthBit(int num, int ith) {
		int bitmask = 1 << ith;
		
		return num | bitmask;
	}
	
	public static void main(String[] args) {
		System.out.println(setIthBit(10, 0));
		System.out.println(setIthBit(10, 1));
		System.out.println(setIthBit(10, 2));
		System.out.println(setIthBit(10, 3));
		System.out.println(setIthBit(10, 4));
		
	}

}
