/**
 * 
 */
package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author caiger
 *Ϊ�˽��е��Զ��������࣬���Ը���leetcode�Զ������ı�����ʽ���������������á�#����ʾnull�Ĳ����
 */
public class ConstructTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(constructTree("1#23#45"));
		TreeNode p=new TreeNode(1);
		p.left=new TreeNode(2);
		p.right=new TreeNode(3);
		p.left.right=new TreeNode(4);
		p.right.left=new TreeNode(5);
		p.right.right=new TreeNode(6);
		p.right.left.right=new TreeNode(7);
		System.out.println(p);
		System.out.println(new InorderTraversal().inorderTraversal(p));
		System.out.println(new InorderTraversal().inorderTraversal(constructTree("1#23#45")));
		System.out.println(new PreorderTraversal().preorderTraversal(constructTree("1#23#45")));
		System.out.println(new LevelorderTraversal().levelorderTraversal(constructTree("1#23#45")));
	}
    public static TreeNode constructTree(String s){
    	if(s==null)
    		return null;
    	TreeNode root =new TreeNode(s.charAt(0)-'0');//char������ʽת����int
    	Queue<TreeNode> que=new LinkedList<TreeNode>();
    	que.add(root);
    	int i=1,n=s.length();
    	TreeNode temp;
    	while(!que.isEmpty()&&i<n){
    		temp=que.poll();
    		if(s.charAt(i)!='#'&&i<n){
    			temp.left=new TreeNode(s.charAt(i)-'0');
    			que.add(temp.left);
    		}
    		i++;
    		if(s.charAt(i)!='#'&&i<n){
    			temp.right=new TreeNode(s.charAt(i)-'0');
    			que.add(temp.right);
    		}
    		i++;
    	}
    	return root;
    }
}
