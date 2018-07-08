package SegmentTreePersistent;

public aspect PersistentSegmentTreea {
	pointcut gha() :
		 (call(* PersistentSegmentTree.*(..)));

	before() : gha() {
		PersistentSegmentTree T = (PersistentSegmentTree)thisJoinPoint.getTarget();
		for(int x : T.Versions) {
			dfs(T, x);
		}
	}
	public void dfs(PersistentSegmentTree T, int i) {
		if(T.NEXT_FREE_INDEX > i) return;
		System.out.println("Node : "+ i + " Value " + T.T[i]);
		dfs(T, T.L[i]);
		dfs(T, T.R[i]);
	}
}
