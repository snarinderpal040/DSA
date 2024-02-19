package leetcode;

public class RemoveFromLinkedList {
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
	
	public static int size(ListNode head) {
		int size = 0;
		
		while(head != null) {
			head = head.next;
			size++;
		}
		
		return size;
	}

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || head.next == null) {
			return null;
		}
		int size = size(head);
		int toRemove = size - n;
		ListNode currHead = head;
		int count = 1;
		if(toRemove > 0){
            while(count < toRemove) {
			currHead = currHead.next;
			count++;
		    }
        }else{
            head = head.next;
        }
		
		currHead.next = currHead.next.next;
		return head;
	}

	public static void main(String[] args) {

	}
}
