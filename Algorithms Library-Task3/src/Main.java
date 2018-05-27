import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import numbertheory.Matrix;
import queryupdate.SegmentTree;
import queryupdate.SparseTable;
import strings.SuffixArray;

public class Main {
	

	
	public static void main(String[] args) {
		String testString = "asdasaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssddddddddddddssssssaabbbbbbbbbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaagggggggggggggggggggggggggggaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxaaaaaaaaaaaaaaaaqqqqqqqqqqqqqqqeeeeee";
		
		SuffixArray SA;
		//#define SegmentTree
		//#ifdef SegmentTree
		SA = new SuffixArray(testString, "SegmenTree");
		//#endif
		
		//#ifdef SegmentTree
		SA = new SuffixArray(testString, "SparseTable");
		//#endif
		
		
	}

}
