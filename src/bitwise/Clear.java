package bitwise;

public class Clear {
	public static int clearIthBit(int num, int ith) {
		int bitmask = ~(1 << ith);
		
		return num & bitmask;
	}
	
	public static void main(String[] args) {
		System.out.println(clearIthBit(10, 1));
		System.out.println(clearIthBit(10, 2));
		System.out.println(clearIthBit(10, 3));
		System.out.println(clearIthBit(10, 4));
		
	}

}
