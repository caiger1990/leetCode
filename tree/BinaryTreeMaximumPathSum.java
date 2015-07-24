/**
 * 
 */
package leetcode.tree;

/**
 * @author caiger
 *
 */
public class BinaryTreeMaximumPathSum {

	public static void main(String[] args) {

	}

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		dfs(root);
		return max;
	}

	/**
	 * @param root
	 *            ��root�����·���ͣ�1.�Ըýڵ�Ϊ����㣬���඼���ǵ�pathsum��max�Ƚ���Ϊ����
	 *            2.�Ըýڵ�Ϊ��/���ӽ�㣬ֻ����һ��·��ʱ���������ͣ����õݹ���ж�̬�滮
	 *            description�����õݹ���ж�̬�滮�����ս���ÿ�����Ϊ��ʱ�����·���͵����ֵ���������������ӽ���·������
	 *            ������Ҫ��������ӽ���·���ͣ��ʲ��ú��������DFS
	 */
	private int dfs(TreeNode root) {
		if (root == null)
			return 0;
		int left = dfs(root.left);
		int right = dfs(root.right);
		int curMax = root.val;
		if (left > 0)
			curMax += left;
		if (right > 0)
			curMax += right;
		// �Ƚ�ÿ������������·���ͣ�����max
		max = Math.max(max, curMax);
		// ������rootΪ�ӽ���һ��·�����ֵ
		return Math.max(left + root.val, Math.max(right + root.val, root.val));
	}

}
