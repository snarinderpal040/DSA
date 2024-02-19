package backtracking;

public class SubSets {

	public static void subsets(String s, int idx, String sub) {
		if (idx == s.length()) {
			if (sub.length() == 0) {
				System.out.println("-");
			} else {
				System.out.println(sub);
			}
			return;
		}

		subsets(s, idx + 1, sub + s.charAt(idx));
		subsets(s, idx + 1, sub);

	}

	public static void main(String[] args) {
		String s = "abcdefghijklmn";
		long start = System.currentTimeMillis();
		subsets(s, 0, "");
		long end = System.currentTimeMillis();
		System.out.println((end - start)/1000.0 + " seconds");
	}

}
