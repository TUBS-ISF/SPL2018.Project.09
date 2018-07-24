import java.util.ArrayList;

import KMP.KMP;
import Matcher.Matcher;
import SegmentTreeLazy.SegmentTreeLazy;
import ZBox.ZBox;
import hash.Hash;
public class Main {
	public static void main(String[] args) {
//		Matcher M = new KMP();
//		M.setPattern("welt");
//		ArrayList<Integer> ans = M.search("hallowelthallowelthallowelthallowelthallowelt");
//		for(int x : ans) {
//			System.out.println(x + " ");
//		}
//		ZBox z = new ZBox();
//		z.search("asd", "asdasd");
		int a[] = { 1, 3, 5, 7, 9, 11 };
		int n = a.length;
		SegmentTreeLazy T = new SegmentTreeLazy(n);
		T.init(a, n);
		System.out.println("summ von 1 bis 3" + T.get(n, 1, 3));
		T.updateRange(n, 1, 5, 10);
		System.out.println("summe nach dem Update" + T.get(n, 1, 3));
	}
}
