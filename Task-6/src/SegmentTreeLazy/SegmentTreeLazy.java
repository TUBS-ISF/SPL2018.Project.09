package SegmentTreeLazy;

public class SegmentTreeLazy {
	public int T[];
	public int lazy[];
	public boolean initialized = false;
	public SegmentTreeLazy(int n) {
		this.lazy = new int[n * 5];
		this.T = new int[n * 5];
	}
	public void updateRange2(int x, int begin, int end, int updatebegin, int updateend, int d) {
		if (lazy[x] != 0) {
			T[x] += (end - begin + 1) * lazy[x];
			if (begin != end) {
				lazy[x * 2 + 1] += lazy[x];
				lazy[x * 2 + 2] += lazy[x];
			}
			lazy[x] = 0;
		}
		if (begin > end || begin > updateend || end < updatebegin)
			return;
		// faul update
		if (begin >= updatebegin && end <= updateend) {
			T[x] += (end - begin + 1) * d;
			if (begin != end) {
				lazy[x * 2 + 1] += d;
				lazy[x * 2 + 2] += d;
			}
			return;
		}
		int mid = (begin + end) / 2;
		updateRange2(x * 2 + 1, begin, mid, updatebegin, updateend, d);
		updateRange2(x * 2 + 2, mid + 1, end, updatebegin, updateend, d);
		T[x] = T[x * 2 + 1] + T[x * 2 + 2];
	}
	public void updateRange(int n, int updatebegin, int updateend, int d) {
		updateRange2(0, 0, n - 1, updatebegin, updateend, d);
	}
	public int get2(int begin, int end, int qs, int qe, int x) {
		if (lazy[x] != 0) {
			T[x] += (end - begin + 1) * lazy[x];
			if (begin != end) {
				lazy[x * 2 + 1] += lazy[x];
				lazy[x * 2 + 2] += lazy[x];
			}
			lazy[x] = 0;
		}
		if (begin > end || begin > qe || end < qs)
			return 0;
		if (begin >= qs && end <= qe)
			return T[x];
		int mid = (begin + end) / 2;
		return get2(begin, mid, qs, qe, 2 * x + 1) + get2(mid + 1, end, qs, qe, 2 * x + 2);
	}
	public int get(int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			return -1;
		}
		return get2(0, n - 1, qs, qe, 0);
	}
	public void init2(int a[], int begin, int end, int x) {
		if (begin > end)
			return;
		if (begin == end) {
			T[x] = a[begin];
			return;
		}
		int mid = (begin + end) >> 1;
		init2(a, begin, mid, (x << 1) + 1);
		init2(a, mid + 1, end, (x << 1) + 2);
		T[x] = T[x * 2 + 1] + T[x * 2 + 2];
	}
	public void init(int a[], int n) {
		initialized = true;
		init2(a, 0, n - 1, 0);
	}
	public void print(int x) {
		print2(x, 0, T.length/5);
	}
	public void print2(int x, int begin, int end) {
		if (begin > end)
			return;
		if (begin == end) {
			System.out.println(T[x]);
			return;
		}
		int mid = (begin + end) >> 1;
		print2((x << 1) + 1, begin, mid);
		print2((x << 1) + 2, mid + 1, end);
	}
}