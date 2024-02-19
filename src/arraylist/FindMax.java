package arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FindMax {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);

		Integer orElse = list.stream().max((i1, i2) -> i1 - i2).orElse(0);
		System.out.println(orElse);

		int max = Integer.MIN_VALUE;

		for (Integer i : list) {
			if (i > max) {
				max = i;
			}
		}

		System.out.println("Max value is : " + max);

		Collections.sort(list, Collections.reverseOrder());
		Optional<Integer> findFirst = list.stream().findFirst();
		System.out.println(findFirst);

	}

}
