package KMP;

import java.util.ArrayList;

import Matcher.Matcher;

public class KMP implements Matcher{
	private int lps[];
	private String pat;
	public void test() {
		System.out.println("Test");
	}
	@Override
	public ArrayList<Integer> search(String txt) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		int M = pat.length();
		int N = txt.length();
		int j = 0;

		int i = 0;
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;
				i++;
			}
			if (j == M) {
				//System.out.println("Found pattern " + "at index " + (i - j));
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
	public void computeLPSArray() {
		int len = 0;
		int i = 1;
		int M = pat.length();
		lps = new int[M];
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
	@Override
	public KMP setPattern(String s) {
		this.pat = s;
		System.out.println("set called");
		return this;
	}
	
}
