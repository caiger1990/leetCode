package twoPointers;

/*
 * Given a linked list, 
 * remove the nth node from the end of list and return its head.
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 */

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		removeNthFromEnd(new ListNode(1), 1);
	}

	// Definition for singly-linked list.
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode removeNthFromEnd(ListNode headListNode, int n) {
		if (headListNode == null || n == 0)// 防御性编程，增加健壮性
			return headListNode;
		/*
		 * 没必要这样做，并没有改变first和second的实例域,不需要新建实例对象
		 * 
		 * ListNode first = new ListNode(headListNode.val); ListNode second =
		 * new ListNode(headListNode.val); first.next = headListNode.next;
		 * second.next = headListNode.next;
		 */
		ListNode first = headListNode;
		ListNode second = headListNode;
		int index = 1;
		while (index != n)// Given n will always be valid.
		{
			first = first.next;
			index++;
		}
		ListNode parent = null;
		while (first.next != null) {
			first = first.next;
			parent = second;
			second = second.next;
		}
		if (parent == null) {
			headListNode = headListNode.next;
			return headListNode;
		} else {
			parent.next = second.next;
			return headListNode;
		}
	}
}
