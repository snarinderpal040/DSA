package bitwise;

public class Update {
	
	public static int setIthBit(int num, int ith) {
		int bitmask = 1 << ith;
		
		return num | bitmask;
	}
	
	public static int clearIthBit(int num, int ith) {
		int bitmask = ~(1 << ith);
		
		return num & bitmask;
	}
	
	public static int updateIthBit(int num, int ith, int bitToSet) {
		int result = 0;
		if(bitToSet == 0) {
			result = clearIthBit(num, ith);
		}else {
			result = setIthBit(num, ith);
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(updateIthBit(10, 1, 0));
		System.out.println(updateIthBit(10, 2, 1));
		System.out.println(updateIthBit(10, 3, 0));
		System.out.println(updateIthBit(10, 4, 1));
		
	}

}
