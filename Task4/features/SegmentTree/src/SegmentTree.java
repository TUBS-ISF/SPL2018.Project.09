import interfaces.ISegmentTree;

public class SegmentTree implements ISegmentTree{
    long d;
    public long merge(long t1, long t2){
        return (Math.min(t1, t2));
    }
    public int height, maxsize, n;
    public long T[];
    
    public void init(long[] a) {
    	n = a.length;
        height = (int)Math.ceil((Math.log(a.length) / Math.log(2)));
        maxsize = (int)(2 * Math.pow(2, height) - 1);
        T = new long[maxsize + 1];
        init1(1, a, 0, a.length - 1);
    }
    public void init1(int x, long[] a, int l, int r) {
        if(l == r) {
            T[x] =  (a[l]);
        }else {
            int m = (l + r) >> 1;
            init1(x << 1, a, l, m);
            init1((x << 1) | 1, a, m + 1, r);
            T[x] = merge(T[x << 1], T[(x << 1) | 1]);
        }
    }
    public long get(int x, int l, int r, int ll, int rr) {
        if(ll <= l && r <= rr) return T[x];
        if(r < ll || rr < l) return  (Long.MAX_VALUE);
        int m = (l + r) >> 1;
        return merge(get(x << 1, l, m, ll, rr), get((x << 1) | 1, m + 1, r, ll, rr));
    }
    public void update(int x, int l, int r, int i, long v) {
        if(l == r && l == i) {
            T[x] =  (v);
            return;
        }
        int m = (l + r) >> 1;
        if(l <= i && i <= m) update(x << 1, l, m, i, v);
        else if(m + 1 <= i && i <= r)update(x << 1 | 1, m + 1, r, i, v);
        T[x] = merge(T[x << 1], T[x << 1 | 1]);
    }
    public void update(int i, long v) {
        update(1, 0, n - 1, i, v);
    }
    public long get(int l, int r) {
        return get(1, 0, n - 1, l, r);
    }
}