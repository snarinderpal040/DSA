package leetcode;

import java.util.HashSet;
import java.util.Stack;

public class StringQuestions {
	public static String reverse(String s) {

//		StringTokenizer st = new StringTokenizer(s, " ", true);
//		
//		while(st.hasMoreTokens()) {
//			String nextToken = st.nextToken();
//			for(int i = nextToken.length()-1; i >= 0; i--) {
//				sb = sb.append(nextToken.charAt(i));
//			}
//		}

		StringBuilder sb = new StringBuilder();
		Stack<String> stack = new Stack<>();

		String[] split = s.split(" ");

		for (int i = split.length - 1; i >= 0; i--) {
			stack.push(split[i]);
		}

		while (!stack.isEmpty()) {
			String pop = stack.pop();
			for (int i = pop.length() - 1; i >= 0; i--) {
				sb.append(pop.charAt(i));
			}
			if (!stack.isEmpty()) {
				sb.append(' ');
			}
		}

		return sb.toString();
	}

	public static int first = -1;
	public static int last = -1;

	public static void firstAndLastOccurence(String s, int idx, char tofind) {
		if (idx == s.length()) {
			System.out.println(first);
			System.out.println(last);
			return;
		}

		char currChar = s.charAt(idx);
		if (currChar == tofind) {
			if (first == -1) {
				first = idx;
			} else {
				last = idx;
			}
		}

		firstAndLastOccurence(s, idx + 1, tofind);
	}

	public static boolean sortedArrayOrNot(int[] arr, int idx) {
		if (idx == arr.length - 1) {
			return true;
		}
		if (arr[idx] <= arr[idx + 1]) {
			return sortedArrayOrNot(arr, idx + 1);
		} else {
			return false;
		}
	}

	public static void moveXToTheEnd(String s, int idx, int count, String newString) {
		if (idx == s.length()) {
			for (int i = 0; i < count; i++) {
				newString += 'x';
			}
			System.out.println(newString);
			return;
		}
		char currChar = s.charAt(idx);
		if (currChar == 'x') {
			count++;
			moveXToTheEnd(s, idx + 1, count, newString);
		} else {
			newString += currChar;
			moveXToTheEnd(s, idx + 1, count, newString);
		}
	}

	public static void subSequences(String s, int idx, String newString) {
		if (idx == s.length()) {
			System.out.print(newString + " ");
			return;
		}
		char currChar = s.charAt(idx);
		idx++;
		subSequences(s, idx, newString);
		subSequences(s, idx, newString + currChar);
	}

	public static void uniqueSubSequences(String s, int idx, String newString, HashSet<String> set) {
		if (idx == s.length()) {
			if (set.contains(newString)) {
				return;
			} else {
				System.out.print(newString + " ");
				set.add(newString);
				return;
			}
		}
		char currChar = s.charAt(idx);
		idx++;
		uniqueSubSequences(s, idx, newString, set);
		uniqueSubSequences(s, idx, newString + currChar, set);
	}

	public static void main(String[] args) {

	}
}
