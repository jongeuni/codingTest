package leet_code_392;

public class Subsequence {

	public static void main(String[] args) {
		String a = "aaaaaa";
		String b = "bbaaaa";
		System.out.println(isSubsequence(a, b));

	}
	
	public static boolean isSubsequence(String s, String t) {
		int len = s.length();
		int count = 0;
		int j = 0;
		
		if(s.length()==0) {
			return true;
		}
		
		for(int i =0; i<s.length(); i++) {
			for(j=0+j; j<t.length(); j++) {
				if(t.charAt(j)==s.charAt(i)) {
					count++;
					break;
				}
			}
			j++;
		}
		
		if(count==len) {
			return true;
		}

		return false;
	}

}
