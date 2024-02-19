package leetcode;

public class LinkedListAddTwoNumbers {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1.next == null && l2.next == null) {
			ListNode node = new ListNode(l1.val + l2.val);
			if(node.val >= 10) {
				node.next = new ListNode(node.val % 10);
				return new ListNode(node.val / 10);
			}else {
				return new ListNode(node.val);
			}
		}
		int carry = 0;
		
		int l3 = l1.val + l2.val;
		ListNode newNode = null;
		if(l3 >= 10) {
			carry = l3%10;
			 newNode =  new ListNode(carry);
			 newNode.next = addTwoNumbers(l1.next, l2.next);
		}else {
			newNode = new ListNode(l3);
			newNode.next = addTwoNumbers(l1.next, l2.next);
		}
		
		return newNode;
	}
	
	public static ListNode addTwoNumbersIterative(ListNode l1, ListNode l2) {
		ListNode temp = new ListNode(0);
		ListNode head = temp;
		int carry = 0;
		
		while(l1 != null || l2 != null || carry > 0) {
			int sum = carry;
			
			if(l1 != null) {
				sum = sum + l1.val;
				l1 = l1.next;
			}
			
			if(l2 != null) {
				sum = sum + l2.val;
				l2 = l2.next;
			}
			
			carry = sum / 10;
			
			sum = sum % 10;
			
			head.next = new ListNode(sum);
			head = head.next;
			
		}
			
		return temp.next;
	}

	public static void main(String[] args) {
		ListNode root1 = new ListNode(2);
		root1.next = new ListNode(4);
		root1.next.next = new ListNode(3);
		root1.next.next.next = null;
		
		ListNode root2 = new ListNode(5);
		root2.next = new ListNode(6);
		root2.next.next = new ListNode(4);
		root2.next.next.next = null;
		
		ListNode addTwoNumbers = addTwoNumbers(root1, root2);
		
		System.out.println(addTwoNumbers.val);
		System.out.println(addTwoNumbers.next.val);
		System.out.println(addTwoNumbers.next.next.val);
		
		ListNode addTwoNumbersIterative = addTwoNumbersIterative(root1, root2);
		System.out.println(addTwoNumbersIterative.val);
		System.out.println(addTwoNumbersIterative.next.val);
		System.out.println(addTwoNumbersIterative.next.next.val);
	}

}
