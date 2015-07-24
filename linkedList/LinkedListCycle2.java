package leetcode.linkedList;

/**
 * Given a linked list, return the node where the cycle begins. If there is no
 * cycle, return null
 * 
 * @author caiger
 */
public class LinkedListCycle2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * �ʼ��˼·�����ÿ���ָ���ҳ������Ľڵ㣬�������ڵ㴦������ֳ�������ͷ�ĵ�һ��Ϊ�ڵ����·�������������ڵ�
	 * ���·�������ָ��Ĺ��̣�aΪhead����ڽڵ㣬bΪ�����һ���������ڵ㣬cΪ������һ��������ڻ��е���һ�� q = 2s,q =
	 * a+b+c+b,s = a+b,����c=a��˵����������ʱ�������ڵ㵽����ڽڵ�ľ������head����ڵľ���
	 * 
	 * @param head
	 * @return
	 */
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head;
		ListNode quick = head.next.next;
		// int s=1;
		// int q=3;
		while (quick != null) {
			if (quick == slow)
				break;
			slow = slow.next;
			// s++;
			if (quick.next == null)
				return null;
			quick = quick.next.next;
			// q+=2;
		}
		if (quick == null)
			return null;
		// ����c�����������ڵ����ڽڵ㣬����a������ڽڵ�
		slow = slow.next.next;
		while (head != slow) {
			head = head.next;
			slow = slow.next;
		}
		return head;
		// �������ڵ㴦������ת��ΪѰ������ͷ�ڵ�������ڵ�����
		// �ڶ�·��ͷ���Ӧ����slow����һ���ڵ㣬slow����·�Ĺ���β���
		// return findNode(slow.next,head,c,s);
	}

	/**
	 * @param slow
	 *            ���������Ľڵ����һ���ڵ㣬�����ڵ�����·��β���
	 * @param head
	 * @param c
	 *            ���н������Ҳ�ǵڶ�·����Ľڵ���
	 * @param s
	 *            ��һ·����Ľڵ���
	 * @return
	 */
	@SuppressWarnings("unused")
	private ListNode findNode(ListNode slow, ListNode head, int c, int s) {
		int diff = Math.abs(c - s);
		ListNode first, second;
		if (c < s) {
			first = head;
			second = slow;
		} else {
			first = slow;
			second = head;
		}
		while (diff > 0) {
			first = first.next;
			diff--;
		}
		while (first != second) {
			first = first.next;
			second = second.next;
		}
		return first;
	}
}
