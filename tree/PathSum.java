/**
 * 
 */
package leetcode.tree;

import leetcode.tree.SameTree.TreeNode;

/**
 *@author caiger
 *Given a binary tree and a sum, 
 *determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null)
			return false;
		//��Ϊ���ж���Ҷ�ӽ���·��������Ҫ�ڵݹ鿪ʼʱ�ж���ǰ����Ƿ���Ҷ�ӽ��
		if(root.left==null&&root.right==null)
			return root.val==sum?true:false;
		return hasPathSum(root.left,sum-root.val)||hasPathSum(root.right,sum-root.val);
	}
}
