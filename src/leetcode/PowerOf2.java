package leetcode;

public class PowerOf2 {
    public static boolean isPowerOfTwo(int n) {//slow code
    	if(n == 0) {
    		return false;
    	}
    	
    	if(n == 1 || n == 2) {
    		return true;
    	}
    	
    	int i = 1;
    	while(i < n) {
    		i = i * 2;
    	}
    	
    	if(i == n) {
    		return true;
    	}
    	
    	return false;
    }


	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(1073741825));
	}

}
