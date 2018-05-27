import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import numbertheory.Matrix;
import queryupdate.SegmentTree;
import queryupdate.SparseTable;
import strings.KMP;
import strings.Matcher;
import strings.SuffixArray;
import strings.ZAlgorithm;

public class Main {

	public static void main(String[] args) {
		String testString = "asdasaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssddddddddddddssssssaabbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaagggggggggggggggggggggggggggaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxaaaaaaaaaaaaaaaaqqqqqqqqqqqqqqqeeeeee";

		SuffixArray SA;
		// #define SegmentTree
		// #ifdef SegmentTree
		SA = new SuffixArray(testString, "SegmenTree");
		// #endif

		// #ifdef SparseTable
		// @ SA = new SuffixArray(testString, "SparseTable");
		// #endif

		String txt = "salamsalamsalamsalam";
		String pat = "salam";
		ArrayList<Integer> L;
		// Matcher is abhaengig von prepocessor
		//#define KMP
		L = Matcher.search(pat, txt);
		for (int x : L) {
			System.out.println(x);
		}

	}

}
