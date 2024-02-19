package linkedlist;


/**
 * 
 * @author narinderpalsingh
 *
 * @param <T> Type of LinkedList
 * 
 * Operations performed : addFirst(), addLast(), addAt(), getSize(), removeFirst(), removeLast(), printLinkedList(),
 * searchKey(), reverse(), deleteNthFromEnd(), findMid(), isPalindrome(), isCycle(Node head), getHead(), getTail()
 * 
 */
public class LinkedList<T> {
	
	class Node{
		T data;
		Node next;
		
		Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public Node head;
	public Node tail;
	public int size;
	
	public void addFirst(T data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		newNode.next = head;
		head = newNode;
	}
	
	public void addLast(T data) {
		Node newNode = new Node(data);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		tail.next = newNode;
		tail = newNode;
	}
	
	/**
	 * prints the Linked List
	 */
	public void printLinkedList() {
		if(head == null) {
			return;
		}
		
		Node temp = head;
		
		while(temp != null) {
			System.out.print(temp.data + " -> ");
			temp = temp.next;
		}
		System.out.print("null \n");
	}
	
	public void addAt(int idx, T val) {
		Node newNode = new Node(val);
		size++;
		if(head == null) {
			head = tail = newNode;
			return;
		}
		
		int i = 1;
		Node temp = head;
		while(i != idx) {
			temp = temp.next;
			i++;
		}
		Node curr = temp.next;
		temp.next = newNode;
		newNode.next = curr;
	}
	
	/**
	 * 
	 * @return the value of the removed Node
	 */
	public T removeFirst(){
		if(size == 0) {
			System.out.println("LinkedList is empty...");
			return null;
		}else if(size == 1) {
			T val = head.data;
			head = tail = null;
			size = 0;
			return val;
		}
		size--;
		T val = head.data;
		head = head.next;
		return val;
	}
	
	/**
	 * 
	 * @return return the value of the removed Node
	 */
	public T removeLast() {
		if(size == 0) {
			System.out.println("LinkedList is Empty...");
			return null;
		}else if(size == 1) {
			size = 0;
			T val = head.data;
			head = tail = null;
			return val;
		}
		
		size--;
		Node curr = head;
		while(curr.next != tail) {
			curr = curr.next;
		}
		
		T val = tail.data;
		curr.next = null;
		tail = curr;
		return val;
	}
	
	/**
	 * 
	 * @param val Key value
	 * @return the index of the Key provided
	 */
	public int searchKey(T val) {
		if(size == 0) {
			return -1;
		}
		Node curr = head;
		int i = 0;
		while(curr != null) {
			if(curr.data == val) {
				return i;
			}
			curr = curr.next;
			i++;
		}
		
		return i;
	}
	
	/**
	 * helper function of searchKeyRecursive(T val)
	 * @param head
	 * @param val
	 * @param idx
	 * @return
	 */
	private int helperRecSearch(Node head, T val, int idx) {
		if(head == null) {
			return -1;
		}
		
		if(head.data == val) {
			return idx;
		}
		
		return helperRecSearch(head.next, val, idx + 1);
	}
	
	/**
	 * 
	 * @param val Key to be searched
	 * @return the index of the Key if found or returns -1 if not found
	 */
	public int searchKeyRecursive(T val) {
		return helperRecSearch(head, val, 0);
	}
	
	/**
	 * reverse linked list iteratively using three pointers. prev, curr, next.
	 * prev points to the curr(head)
	 * curr points to prev.next
	 * next will be updated in the loop to keep track of the next element.
	 */
	public void reverse() {
		if(head == null) {
			return;
		}
		if(head == tail) {
			return;
		}
		Node prev = head;
		Node curr = head.next;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		head.next = null;
		tail = head;
		head = prev;
	}
	
	public void deleteNthFromEnd(int n) {
		int size = getSize();
		this.size--;
		if(n == size) {
			head = head.next;
			return;
		}
		
		int i = 1;
		Node temp = head;
		while(i < size - n) {
			temp = temp.next;
			i++;
		}
		temp.next = temp.next.next;
	}
	
	public Node findMid() {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public boolean isPalindrome() {
		//Base case
		if(head == null || head.next == null) {
			return true;
		}
		
		Node mid = findMid();
		System.out.println(mid.data);
		
		//reverse half
		Node prev = null;
		Node curr = mid;
		Node next;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		Node rightHead = prev;
		Node leftHead = head;
		
		//check if the linked list is palindrome now
		while(rightHead != null) {
			if(rightHead.data != leftHead.data) {
				return false;
			}
			rightHead = rightHead.next;
			leftHead = leftHead.next;
		}
		return true;
	}
	
	public boolean isCycle(Node head) {
		Node slow = head;
		Node fast = head;
		
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if(slow == fast) {
				return true;
			}
		}
		return false;
	}
	
	public Node getHead() {
		return head;
	}
	
	public Node getTail() {
		return tail;
	}
	
	/**
	 * prints the size of the Linked List
	 */
	public int getSize() {
		System.out.println("Size of linkedlist : " + size);
		return size;
	}

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<>();
		ll.addFirst(1);
		ll.addFirst(2);
		ll.addLast(2);
		ll.addLast(1);
		ll.addFirst(2);
		ll.addAt(3, 2);
		ll.printLinkedList();
		LinkedList<Integer>.Node head = ll.getHead();
		LinkedList<Integer>.Node tail = ll.getTail();
		System.out.println(head.data);
		System.out.println(tail.data);
		tail.next = head;
		
		String isCycle = ll.isCycle(head) ? "Cycle exists" : "Cycle does NOT exist" ;
		System.out.println(isCycle);

	}

}
