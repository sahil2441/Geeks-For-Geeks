package linked_list;

import utilities.ListNode;

public class ReverseLinkedlList {

	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);

		ListNode next = head.next;
		ListNode newHead = reverseReverseList(head, next);

		head.next = null;
		while (newHead != null) {
			System.out.println(newHead.val);
			newHead = newHead.next;
		}
	}

	private static ListNode reverseReverseList(ListNode head, ListNode next) {
		if (next == null)
			return head;

		ListNode temp = next.next;
		next.next = head;
		return reverseReverseList(next, temp);
	}
}
