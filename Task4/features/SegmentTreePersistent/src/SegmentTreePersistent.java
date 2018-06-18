import interfaces.ISegmentTreePersistent;

public  class SegmentTreePersistent implements ISegmentTreePersistent{
    public int height, maxsize, n;
    public int T[];
    public  int L[], R[];
    public static int NEXT_FREE_INDEX=2;
    
    public void init(int[] a) {
    	n = a.length;
        height = (int)Math.ceil((Math.log(a.length) / Math.log(2)));
        maxsize = (int)(2 * Math.pow(2, height) - 1);
        T = new int[maxsize + 10];
        L = new int[maxsize + 10];
        R = new int[maxsize + 10];
        init2(1, a, 0, a.length - 1);
    }
    public void init2(int id, int[] a, int l, int r) {
        if(l == r) {
            T[id] = a[l];
        }else {
            int m = (l + r) >> 1;
            L[id]=NEXT_FREE_INDEX++; //System.out.println("R " + L[id]);
            R[id]=NEXT_FREE_INDEX++;
            init2(L[id], a, l, m);
            init2(R[id], a, m + 1, r);
            
            T[id] = Math.min(T[L[id]], T[R[id]]);
        }
    }
    public int get(int id, int l, int r, int ll, int rr) {
        if(ll <= l && r <= rr) return T[id];
        if(r < ll || rr < l) return Integer.MAX_VALUE;
        int m = (l + r) >> 1;
        return Math.min(get(L[id], l, m, ll, rr), get(R[id], m + 1, r, ll, rr));
    }
    public int update(int id, int l, int r, int i, int v) {
        int ID = NEXT_FREE_INDEX++; 
        T[ID]=T[id]; 
        if(l == r && l == i) {
            T[ID] = v;
            return ID;
        }
        int m = (l + r) >> 1;
        L[ID] = L[id]; R[ID] = R[id];
        if(l <= i && i <= m) {
            L[ID]=update(L[ID], l, m, i, v);
        }
        else if(m + 1 <= i && i <= r){
            R[ID]=update(R[ID], m + 1, r, i, v);
        }
        
        T[ID] = Math.min(T[L[ID]], T[R[ID]]);
        return ID;
    }
    public void update(int id, int i, int v) {
        update(id, 0, n - 1, i, v);
    }
    public int get(int id, int l, int r) {
        return get(id, 0, n - 1, l, r);
    }
}