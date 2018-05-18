package queryupdate;


import queryupdateI.SegmentTreeI;

/**
 *
 * @author Toghrul
 */
// Use Template
public abstract class SegmentTree <TT>{
	public class Node {
		TT d;

		public Node(TT d) {
			this.d = d;
		}
	}

	public abstract TT merge(TT t1, TT t2);

	public int height, maxsize, n;
	public TT T[];

	public SegmentTree(TT[] a) {
		n = a.length;
		height = (int) Math.ceil((Math.log(a.length) / Math.log(2)));
		maxsize = (int) (2 * Math.pow(2, height) - 1);
		
        TT[] ar = (TT[]) new Object[maxsize + 1];
        this.T = ar;
		init(1, a, 0, a.length - 1);
	}

	public void init(int x, TT[] a, int l, int r) {
		if (l == r) {
			T[x] = (a[l]);
		} else {
			int m = (l + r) >> 1;
			init(x << 1, a, l, m);
			init((x << 1) | 1, a, m + 1, r);
			T[x] = (TT) merge(T[x << 1], T[(x << 1) | 1]);
		}
	}

	public TT get(int x, int l, int r, int ll, int rr) {
		if (ll <= l && r <= rr)
			return T[x];
		if (r < ll || rr < l) {
			TT a;
			return null;
		}
			
		int m = (l + r) >> 1;
		return merge(get(x << 1, l, m, ll, rr), get((x << 1) | 1, m + 1, r, ll, rr));
	}

	public void update(int x, int l, int r, int i, TT v) {
		if (l == r && l == i) {
			T[x] = (v);
			return;
		}
		int m = (l + r) >> 1;
		if (l <= i && i <= m)
			update(x << 1, l, m, i, v);
		else if (m + 1 <= i && i <= r)
			update(x << 1 | 1, m + 1, r, i, v);
		T[x] = (TT) merge(T[x << 1], T[x << 1 | 1]);
	}

	public void update(int i, TT v) {
		update(1, 0, n - 1, i, v);
	}

	public TT get(int l, int r) {
		return get(1, 0, n - 1, l, r);
	}
}
