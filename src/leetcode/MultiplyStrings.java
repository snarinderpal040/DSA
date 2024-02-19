package leetcode;

public class MultiplyStrings {
	public String multiply(String num1, String num2) {
        long i = Long.parseLong(num1);
        long j = Long.parseLong(num2);
        
        long k = i * j;
        return String.valueOf(k);
    }
	
	public static void main(String[] args) {
		MultiplyStrings ms = new MultiplyStrings();
		String multiply = ms.multiply("6", "5");
		System.out.println(multiply);
	}

}
