package bitwise;

public class GetIthBit {
	public static int getIthBit(int num, int ith) {
		int bitmask = 1 << ith;
		
		//and of 0 and 1 is always 0. If the whole number becomes 0 then it means our bit was also 0 because we are bit masking
		//it with 1. ELse it is 1.
		if((num & bitmask) == 0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getIthBit(10, 0));
		System.out.println(getIthBit(10, 1));
		System.out.println(getIthBit(10, 2));
		System.out.println(getIthBit(10, 3));
	}

}
