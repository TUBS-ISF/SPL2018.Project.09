package strings;

import java.util.ArrayList;

public class Matcher {

	//#ifdef ZF
//@	public static class ZAlgorithm {
//@
//@
//@		public static ArrayList<Integer> search(String text, String pattern) {
//@			String s = text + "$" + pattern;
//@			int[] z = new int[s.length()];
//@			int L = 0, R = 0;
//@			for (int i = 0; i < s.length(); i++) {
//@				if (i > R) {
//@					L = R = i;
//@					while (R < s.length() && s.charAt(R - L) == s.charAt(R))
//@						R++;
//@					z[i] = R - L;
//@					R--;
//@				} else {
//@					int k = i - L;
//@					if (z[k] < R - i + 1)
//@						z[i] = z[k];
//@					else {
//@						L = i;
//@						while (R < s.length() && s.charAt(R - L) == s.charAt(R))
//@							R++;
//@						z[i] = R - L;
//@						R--;
//@					}
//@				}
//@			}
//@			ArrayList<Integer> ans = new ArrayList<Integer>();
//@			for(int i = 0; i < z.length; i++) {
//@				if(z[i] == pattern.length()) {
//@					//System.out.println("Pattern founded at index" + (i - pattern.length()-1));
//@					ans.add(i-pattern.length()-1);
//@				}
//@			}
//@			return ans;
//@		}
//@
//@	}
//#endif
	
	//#ifdef KMP
	public static class KMP {
		public static ArrayList<Integer> search(String pat, String txt) {
			ArrayList<Integer> ans = new ArrayList<Integer>();
			int M = pat.length();
			int N = txt.length();

			int lps[] = new int[M];
			int j = 0;

			computeLPSArray(pat, M, lps);

			int i = 0;
			while (i < N) {
				if (pat.charAt(j) == txt.charAt(i)) {
					j++;
					i++;
				}
				if (j == M) {
					System.out.println("Found pattern " + "at index " + (i - j));
					ans.add(i - j);
					j = lps[j - 1];
				}

				else if (i < N && pat.charAt(j) != txt.charAt(i)) {
					if (j != 0)
						j = lps[j - 1];
					else
						i = i + 1;
				}
			}
			return ans;
		}

		public static void computeLPSArray(String pat, int M, int lps[]) {
			int len = 0;
			int i = 1;
			lps[0] = 0;

			while (i < M) {
				if (pat.charAt(i) == pat.charAt(len)) {
					len++;
					lps[i] = len;
					i++;
				} else {
					if (len != 0) {
						len = lps[len - 1];

					} else {
						lps[i] = len;
						i++;
					}
				}
			}
		}
	}
	//#endif
	public static ArrayList<Integer> search(String pat, String text) {
		//#ifdef KMP
		return KMP.search(pat, text);
		//#endif
		//#ifdef ZF
//@		return ZAlgorithm.search(pat, text);
		//#endif
	}

}
