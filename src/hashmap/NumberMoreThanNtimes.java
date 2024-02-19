package hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class NumberMoreThanNtimes {
	
	public static void solution(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		Arrays
			.stream(arr)
			.forEach(n -> map.put(n, map.getOrDefault(n, 0) + 1));
		
		map
			.keySet()
			.stream()
			.filter(n -> map.get(n) >= arr.length/3)
			.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,3,2,5,1,3,1,5,1};
		solution(arr);
	}

}
