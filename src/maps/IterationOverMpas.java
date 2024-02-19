package maps;

import java.util.HashMap;
import java.util.Map;

public class IterationOverMpas {
	
	public static Map<Integer, String> getMap(){
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "Monday");
		map.put(2, "Tuesday");
		map.put(3, "Wednesday");
		map.put(4, "Thursday");
		map.put(5, "Friday");
		map.put(6, "Saturday, Weekend!!!");
		map.put(7, "Sunday, Weekend!!!");
		return map;
	}
	
	public static void main(String[] args) {
		Map<Integer, String> map = getMap();
		map.forEach((k,v) -> {
			System.out.println(String.format("Day: %s . day %s", k, v));
		});
	}

}
