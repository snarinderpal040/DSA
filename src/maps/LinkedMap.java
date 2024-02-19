package maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedMap {

	public static void main(String[] args) {
		Map<String, Integer> map = new LinkedHashMap<>();
		map.put("India", 150);
		map.put("China", 140);
		map.put("United States", 60);
		map.put("Canada", 30);
		map.put("Japan", 70);
		map.put("Russia", 80);
		map.put("Pakistan", 101);
		map.put("Australia", 45);
		map.put("New Zealand", 8);
		
		map.forEach((k,v)->{
			System.out.println(String.format("%s -> %s", k, v));
		});
	}

}
