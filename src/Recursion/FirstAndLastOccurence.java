package Recursion;

public class FirstAndLastOccurence {
	public static int first = -1;
	public static int last = -1;

	public static void firstAndLastOccurenceOfAnElement(String s, char charToFind, int idx) {
		if (idx == s.length()) {
			System.out.println(first + 1);
			System.out.println(last + 1);
			return;
		}

		char currChar = s.charAt(idx);

		if (currChar == charToFind) {
			if (first == -1) {
				first = idx;
			} else {
				last = idx;
			}
		}
		firstAndLastOccurenceOfAnElement(s, charToFind, idx+1);
	}

	public static void main(String[] args) {
		firstAndLastOccurenceOfAnElement("narindersingh", 'n', 0);
	}

}
