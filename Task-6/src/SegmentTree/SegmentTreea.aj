package SegmentTree;

import SparseTable.SparseTable;

public aspect SegmentTreea {
	pointcut gh(int l, int r) :
		 (call(* SegmentTree.get(*,*))) && args(l,r);

	before(int l, int r) : gh(l,r) {
		SegmentTree T = (SegmentTree)thisJoinPoint.getTarget();
		if(T.n < r) {
			try {
				throw new Exception("indexoutofboundsexception in Table");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(r < l) {
			try {
				throw new Exception("left must be less than r");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
