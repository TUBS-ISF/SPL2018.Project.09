import java.math.BigInteger;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import interfaces.IBigInt;
import interfaces.IMatrix;
import interfaces.IFenwickTree;
import interfaces.ISegmentTree;
import interfaces.ISparseTable;
import interfaces.IKMP;
import interfaces.IMatcher;
import interfaces.ISuffixArray;
import interfaces.ZAlgorithm;

public class Main {

	public static void main(String[] args) {
		//#define KMP
		Integer a = 12;
		FenwickTree<Integer> T = new FenwickTree<Integer>(Integer.class, 100, 0) {
			@Override
			public Integer add(Integer a, Integer b) {
				return a  + b;
			}
		};
		T.add(0, 13);
		System.out.println(T.rsq(10));
	}

}
