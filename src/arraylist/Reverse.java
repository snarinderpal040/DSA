package arraylist;

import java.util.List;

public class Reverse {

	public static void main(String[] args) {
		List<Integer> list = List.of(1, 2, 3, 4, 5);

		for (int i = list.size() - 1; i >= 0; i--) {
			System.out.print(list.get(i) + " ");
		}
	}

}
