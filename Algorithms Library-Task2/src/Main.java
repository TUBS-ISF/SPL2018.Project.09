import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import numbertheory.Matrix;
import queryupdate.SegmentTree;
import queryupdate.SparseTable;
import strings.SuffixArray;

public class Main {
	

	private static Set<String> propertiesSet;
	
	public static void main(String[] args) {
		propertiesSet = new HashSet<String>();
		for(int i = 0; i < args.length; i++) {
			propertiesSet.add(args[i]);
		}
		Integer[] a = new Integer[10000];
		for(int i = 0;i < a.length; i++) {
			a[i] = (int)(Math.random() * 100);
		}
		// Segment Tree for sum, min, max als with BigNum etc O(long(n)) 
		SegmentTree<Integer> T = new SegmentTree<Integer>(a, Integer.MIN_VALUE) {

			@Override
			public Object merge(Object t2, Object t3) {
				// TODO Auto-generated method stub
				Integer a = (Integer)t2;
				Integer b = (Integer)t3;
				return Math.max(a, b);
			}
			
			
		};
		// O(long n) time.
		T.update(0, 15);
		System.out.println(T.get(0, 5));
		
		// Sparse Table for range query min, max also with BigNum etc O(1) 
		SparseTable<Integer> ST = new SparseTable<Integer>(a) {

			@Override
			public Integer merge(Object x, Object y) {
				// TODO Auto-generated method stub
				Integer a = (Integer)x;
				Integer b = (Integer)y;
				//System.out.println(a + " " + b);
				return Math.max(a, b);
			}
			
		};
		// O(1) time
		System.out.println(ST.get(2,5));
		
		String test = "akljsdbakljsdbklajsdkajsdnkljasndkssssssssskjndsjjsjdnajsdnasdkasdkjansdkjanskjdna";
		// waehle algorithmus durch parametr
		
		if(propertiesSet.contains("SegmentTree")) {
			SuffixArray SA = new SuffixArray(test, "SegmentTree"); // or SparseTable
			System.out.println(SA.getPreffix(0, 7));
		}else if(propertiesSet.contains("SegmentTree")) {
			SuffixArray SA = new SuffixArray(test, "SparseTable"); // or SparseTable
			System.out.println(SA.getPreffix(0, 7));
		}
		
		
		
	}

}