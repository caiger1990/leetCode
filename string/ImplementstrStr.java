package leetcode.string;

public class ImplementstrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	 * @param s ��ƥ����ַ���
	 * @param n	ƥ����ַ���
	 * @return	n��s�е�һ�γ���ʱs�е�һ���ַ���λ�ã�������ʱ����-1
	 */
	public static int strStr(String s,String n){
		if(s == null)
			return -1;
		if(n == null||n.length() == 0)
			return 0;
		int i = 0,j = 0;
		int[] next = getNext(n);
		while(i<s.length()&&j<n.length()){
			if(s.charAt(i) == n.charAt(j)||j == -1){
				i++;
				j++;
			}
			else{
				//
				j = next[j];
			}
		}
		if(j == n.length())
			return i = j;
		return -1;
	}
	/**
	 * Description�� ȷ��Ŀ���Ӵ�ÿ��λ��Ԫ�ص��ǰ׺ƥ���Ӵ���
	 * @param n Ҫƥ����Ǹ���
	 * @return ����һ��next���飬�������i��λ�õ����ֱ�ʾ�����������Ӵ��Ƚ�iλ�õ�Ԫ�ز�ͨ��ʱ��
	 * 		     ת���Ƚ�next[i]λ�õ��Ӵ�Ԫ��
	 */
	private static int[] getNext(String n) {
		int[] next  = new int[n.length()];
		next[0] = 0;
		int j = 0,k = -1;
		while(j<n.length()-1){
			if(n.charAt(j) == n.charAt(k)){
				j++;
				k++;
				next[j] = k;
			}
			else{
				j = next[k];
			}
		}
		//����������Ӵ�ƥ����̵ĸĽ�����:
		//s[i] != n[j]ʱ��ҪѰ����һ��n�бȽϵ�λ�ã���n[j] == n[k],��s[i] != n[k],ֻ��Ҫ�Ƚ�s[i]��n[next[k]]
//		if(n.charAt(j) == n.charAt(k)){
//			j++;
//			k++;
//			if(n.charAt(j) == n.charAt(k))
//				next[j] = next[k];
//			else {
//				next[j] = k;
//			}
//		}		
		return next;
	}
}
