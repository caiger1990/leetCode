package leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges. For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * @author caiger
 */
public class SummaryRanges {

	public static void main(String[] args) {

	}

	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if (nums == null || nums.length == 0)
			return res;
		int i = 0;
		// Tips��ѭ��Ҫ����һ�����������ֻ���ǳ�ʼ�����
		// ���ѭ������ÿ�δ洢���
		// �ڲ�ѭ������ÿ�ν��
		while (i < nums.length) {
			StringBuilder s = new StringBuilder();
			int start = nums[i++];
			s.append(start);
			while (i < nums.length && nums[i] == nums[i - 1] + 1)
				i++;
			int end = nums[i - 1];
			if (end > start)
				s.append("->" + end);
			res.add(s.toString());
		}
		return res;
	}
}
