package stacks;

import java.util.Stack;

public class NextGreaterElement {
	
	public static int[] nextGreater(int[] arr) {
		Stack<Integer> stack = new Stack<>();
		
		int[] nextElements = new int[arr.length];
		
		for(int i = arr.length - 1; i >= 0; i--) {
			while(!stack.isEmpty() && arr[i] >= stack.peek()) {
				stack.pop();
			}
			
			if(!stack.isEmpty()) {
				nextElements[i] = stack.peek();
			}else {
				nextElements[i] = -1;
			}
			
			stack.push(arr[i]);
		}
		
		return nextElements;
	}

	public static void main(String[] args) {
		int[] arr = {6,8,0,1,3};
		
		for(int i : nextGreater(arr)) {
			System.out.print(i + " ");
		}
	}

}
