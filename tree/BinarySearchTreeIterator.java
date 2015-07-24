/**
 * 
 */
package leetcode.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author caiger
 *
 */
public class BinarySearchTreeIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	// �洢���е�ÿ���ڵ�
	private List<Integer> valList = new LinkedList<Integer>();
	private int index = 0;

	// �������BST���Ϊ��������
	public BinarySearchTreeIterator(TreeNode root) {
		if (root == null)
			return;
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode temp = root;
		while (temp != null || !stack.isEmpty()) {
			while (temp != null) {
				stack.push(temp);
				temp = temp.left;
			}
			temp = stack.pop();
			valList.add(temp.val);
			temp = temp.right;
		}
	}

	/** @return whether we have a next smallest number */
	// ÿ�ε���hasNext����������һ����ָ������ƶ�һλ
	public boolean hasNext() {
		if (index < valList.size()) {
			index++;
			return true;
		}
		return false;
	}

	/** @return the next smallest number */
	// ���ص���ָ���ǰһ��Ԫ��
	public int next() {
		return valList.get(index - 1);
	}
}
/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */

