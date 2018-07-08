import java.util.ArrayList;

import KMP.KMP;
import Matcher.Matcher;

public class Main {
	public static void main(String[] args) {
		Matcher M = new KMP();
		M.setPattern("welt");
		ArrayList<Integer> ans = M.search("hallowelthallowelthallowelthallowelthallowelt");
		for(int x : ans) {
			System.out.println(x + " ");
		}
	}
}
