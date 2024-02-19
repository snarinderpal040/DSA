package linkedlist;

public class DoublyLinkedList {
	
	public static class Node{
		int val;
		Node next;
		Node prev;
		
		public Node(){
			
		}
		
		public Node(int val){
			this.val = val;
		}
		
		public Node(int val, Node next, Node prev){
			this.val = val;
			this.next = next;
			this.prev = prev;
		}
	}
	
	public Node head;
	public Node tail;
	private int size = 0;
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(int val) {
		Node newNode = new Node(val);
		size++;
		if(isEmpty()) {
			head = tail = newNode;
			return;
		}
		
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		head.prev = null;
	}
	
	public void addlast(int val) {
		Node newNode = new Node(val);
		size++;
		if(isEmpty()) {
			head = tail = newNode;
			return;
		}
		
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		tail.next = null;
	}
	
	public void print() {
		Node curr = head;
		while(curr != tail) {
			System.out.print(curr.val + " ");
			curr = curr.next;
		}
		System.out.println(curr.val);
	}
	
	public static void main(String[] args) {
		DoublyLinkedList ll = new DoublyLinkedList();
		ll.addFirst(0);
		ll.addlast(2);
		ll.addlast(3);
		ll.addFirst(4);
		
		ll.print();
	}

}
