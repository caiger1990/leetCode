package leetcode.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


/*
 * Given a binary tree, return the level order traversal of its nodes' values.
 */
public class LevelorderTraversal {
	
	public List<List<Integer>> levelorderTraversal(TreeNode root){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		//List<Integer> nextList=new ArrayList<Integer>();
		Queue<TreeNode> que=new ArrayDeque<TreeNode>();
		int pre=1,now=0;
		que.add(root);
		while(!que.isEmpty()){
			//�ط�����Ӧ����ѭ���ڶ��壬ÿ�ζ�������ʵ��
			List<Integer> nextList=new ArrayList<Integer>();
			//nextList.clear();��res����ӵ���nextList���������ͣ���һ�����res�е�nextListҲ��գ�
			while(pre!=0){
				TreeNode temp=que.poll();
				pre--;
				nextList.add(temp.val);
				if(temp.left!=null){
					que.add(temp.left);
					now++;
				}
				if(temp.right!=null){
					que.add(temp.right);
					now++;
				}	
			}
			pre=now;
			now=0;
			res.add(nextList);
		}
		return res;
	}
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if(root==null)
			return res;
		//List<Integer> nextList=new ArrayList<Integer>();
		Stack<List<Integer>> stack=new Stack<List<Integer>>();
		Queue<TreeNode> que=new ArrayDeque<TreeNode>();
		int pre=1,now=0;
		que.add(root);
		while(!que.isEmpty()){
			//�ط�����Ӧ����ѭ���ڶ��壬ÿ�ζ�������ʵ��
			List<Integer> nextList=new ArrayList<Integer>();
			//nextList.clear();��res����ӵ���nextList���������ͣ���һ�����res�е�nextListҲ��գ�
			while(pre!=0){
				TreeNode temp=que.poll();
				pre--;
				nextList.add(temp.val);
				if(temp.left!=null){
					que.add(temp.left);
					now++;
				}
				if(temp.right!=null){
					que.add(temp.right);
					now++;
				}	
			}
			pre=now;
			now=0;
			stack.add(nextList);
		}
		while(!stack.isEmpty()){
			res.add(stack.pop());
		}
		return res;
	}	
}
	

