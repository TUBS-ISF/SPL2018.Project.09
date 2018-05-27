package strings;

import java.util.ArrayList;

public class KMP {
	public  static int[]compute(String s) {
		int[] p = new int[s.length()];
		p[0] = 0;
		int i = 1;
		int M = s.length();
		// length of the previous longest prefix suffix
		int len = 0;
		while(i < M) {
			if(s.charAt(i) == s.charAt(len)) {
				len++;
				p[i] = len;
				i++;
			}else {
				if(len != 0) len = p[len-1];
				else {
					p[i] = 0;
					i++;
				}
			}
		}
		return p;
	}
	public static ArrayList<Integer> search(String text, String pattern) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int[] p = compute(pattern);
		int i = 0;
		int j = 0;
		while(i < pattern.length()) {
			if(pattern.charAt(j) == text.charAt(i)) {
				i++;
				j++;
			}
			if(j == pattern.length()) {
				ans.add(i - j);
				j = p[j-1];
			}else if(i < text.length() && pattern.charAt(j) != text.charAt(i)) {
				if(j != 0) {
					j = p[j-1];
				}else i = i + 1;
			}
		}
		return ans;
	}

}
