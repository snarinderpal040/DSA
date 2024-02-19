package linkedlist;

import java.util.Arrays;

public class LinkedListPrec {

	public static class Node {
		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}
	}

	private Node head;
	
	private Node tail;
	
	private int size = 0;

	public int getSize() {
		return size;
	}
	
	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public void addFirst(int data) {
		Node temp = new Node(data);
		size++;
		if (isEmpty()) {
			head = tail = temp;
			return;
		}
		temp.next = head;
		head = temp;
	}

	public void addLast(int data) {
		Node temp = new Node(data);
		size++;
		if (isEmpty()) {
			head = tail = temp;
			return;
		}
		tail.next = temp;
		tail = temp;
	}

	public void printLinkedList() {
		if(detectCycle()) {
			System.err.println("Cycle in Linked List");
			return;
		}
		
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
	
	public void printLinkedList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.val + " -> ");
			curr = curr.next;
		}
		System.out.println("null");
	}
	

	public void addAtIndex(int data, int idx) {
		Node newNode = new Node(data);
		if (idx == 0) {
			addFirst(data);
			return;
		}
		if (idx > getSize())
			throw new IllegalArgumentException("Please provide the correct index");
		if (idx == getSize()) {
			addLast(data);
			return;
		}
		size++;
		Node curr = head;
		int count = 0;
		while (count < idx - 1) {
			curr = curr.next;
			count++;
		}
		Node temp = curr.next;
		curr.next = newNode;
		newNode.next = temp;
	}

	public void removeFirst() {
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		size--;
		head = head.next;
	}

	public void removeLast() {
		Node curr = head;
		if (head == null) {
			System.out.println("Linked List is empty");
			return;
		}
		size--;
		while (curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
		tail = curr;
	}

	public int searchKey(int data) {
		if (head == null) {
			return -1;
		}

		Node curr = head;
		int index = 0;
		while (curr != null) {
			if (curr.val == data) {
				return index;
			}
			curr = curr.next;
			index++;
		}

		return -1;
	}

	public void reverse() {
		if (head == null || head == tail) {
			return;
		}

		Node prev = null;
		Node curr = head;
		Node next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		head.next = null;
		tail = head;
		head = prev;
	}

	public Node mid() {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public boolean isPalindrome() {
		if(detectCycle()) {
			return false;
		}
		if(head == null || head.next == null) {
			return true;
		}
		Node mid = mid();
		Node reverseHalfHead = reverseHalf(mid);
		Node currHead = head;

		while (reverseHalfHead != null) {
			if (currHead.val != reverseHalfHead.val) {
				return false;
			}
			currHead = currHead.next;
			reverseHalfHead = reverseHalfHead.next;
		}
		return true;
	}

	private Node reverseHalf(Node mid) {
		Node prev = null;
		Node curr = mid;
		Node next;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		mid.next = null;
		Node reversedHead = prev;
		return reversedHead;
	}
	
	public void zigzag() {
		if(head == null) {
			return;
		}
		
		Node slow = head;
		Node fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		Node mid = slow;
		
		//reversing the half
		Node tempRightHead = mid.next;
		mid.next = null;
		
		Node prev = null;
		Node curr = tempRightHead;
		Node next;
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		//Making a zig zag
		Node right = prev;
		Node left = head;
		Node leftNext,rightNext;
		while(left != null && right != null) {
			leftNext = left.next;
			left.next = right;
			rightNext = right.next;
			right.next = leftNext;
			
			left = leftNext;
			right = rightNext;
		}
	}
	
	public boolean detectCycle() {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public void removeCycle() {
		Node slow = head, fast = head;
		boolean cycle = false;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(fast == slow) {
				cycle = true;
				System.out.println("Cycle removed");
				break;
			}
		}
		
		if(!cycle) {
			System.out.println("Cycle does not exist");
			return;
		}
		
		slow = head;
		Node prev = null;
		
		while(slow != fast) {
			prev = fast;
			slow = slow.next;
			fast = fast.next;
		}
		prev.next = null;
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,3,4,5,6,7 };
		LinkedListPrec ll = new LinkedListPrec();

		Arrays.stream(nums).forEach(n -> ll.addLast(n));

		System.out.println("********** Size of Linked List ***********");
		System.out.println(ll.getSize());

		System.out.println("********* Printing Linked List ***********");
		ll.printLinkedList();
		
		ll.zigzag();
		ll.printLinkedList();
		
	}

}
