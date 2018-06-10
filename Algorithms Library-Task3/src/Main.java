import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import numbertheory.BigInt;
import numbertheory.Matrix;
import queryupdate.FenwickTree;
import queryupdate.SegmentTree;
import queryupdate.SparseTable;
import strings.KMP;
import strings.Matcher;
import strings.SuffixArray;
import strings.ZAlgorithm;

public class Main {

	public static void main(String[] args) {
		//#define KMP
		Integer a = 12;
		FenwickTree<Integer> T = new FenwickTree<Integer>(Integer.class, 100) {
			@Override
			public Integer add(Integer a, Integer b) {
				// TODO Auto-generated method stub
				return a  + b;
			}
		};
	}

}
