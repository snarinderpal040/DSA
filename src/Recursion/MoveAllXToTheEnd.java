package Recursion;

public class MoveAllXToTheEnd {
	public static void move(String s, String newString, int idx, int xCount) {
		if (idx == s.length()) {
			for (int i = 0; i < xCount; i++) {
				newString = newString + "x";
			}
			System.out.println(newString);
			return;
		}
		char currChar = s.charAt(idx);
		if (currChar == 'x') {
			xCount++;
		} else {
			newString += currChar;
		}
		move(s, newString, idx + 1, xCount);
	}

	public static void main(String[] args) {
		move("nxaxrindxexr", "", 0, 0);
	}

}
