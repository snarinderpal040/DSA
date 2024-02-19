package leetcode;

import java.util.ArrayList;
import java.util.List;


public class GenerateParanthesis {
	
	public static void solution(List<String> list, int n, int left, int right, String s) {
		if(s.length() == n * 2) {
			list.add(s);
			return;
		}
		
		if(left < n) {
			solution(list, n, left + 1, right, s + "(");
		}
		
		if(right < left) {
			solution(list, n, left, right + 1, s + ")");
		}
	}
	
	public static List<String> generateParenthesis(int n){
		List<String> list = new ArrayList<>();
		
		int left = 0;
		int right = 0;
		
		solution(list, n, left, right, "");
		
		return list;
	}
	
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));

	}
}
