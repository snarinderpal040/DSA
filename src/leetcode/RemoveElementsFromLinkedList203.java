package leetcode;

import java.util.Arrays;

public class RemoveElementsFromLinkedList203 {

	public class ListNode {
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

	public ListNode head;

	public ListNode tail;

	int size = 0;

	public boolean isEmpty() {
		return head == null;
	}

	public ListNode addFirst(int data) {
		ListNode newNode = new ListNode(data);
		size++;
		if (head == null) {
			head = tail = newNode;
			return head;
		}

		newNode.next = head;
		head = newNode;
		return head;
	}

	public void addLast(int data) {
		ListNode temp = new ListNode(data);
		size++;
		if (isEmpty()) {
			head = tail = temp;
			return;
		}
		tail.next = temp;
		tail = temp;
	}

	public void printLinkedList(ListNode head) {
		ListNode curr = head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}

	public ListNode removeElements(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode curr = newHead;
		while(curr.next != null) {
			if(curr.next.val == val) {
				curr.next = curr.next.next;
			}else {
				curr = curr.next;
			}
		}
		
		return newHead.next;
	}
	
	public ListNode remove(ListNode head, int val) {
		if(head == null) {
			return null;
		}
		head.next = remove(head.next, val);
		if(head.val == val) {
			return head.next;
		}
		return head;
	}

	public static void main(String[] args) {
		int[] nodes = { 2, 2,2,2,2,2, };
		RemoveElementsFromLinkedList203 ll = new RemoveElementsFromLinkedList203();
		Arrays.stream(nodes).forEach(ll::addLast);
		
		ListNode head = ll.addFirst(2);
		ll.printLinkedList(head);
		
		ListNode remove = ll.remove(head, 2);
		ll.printLinkedList(remove);
		
	}

}
