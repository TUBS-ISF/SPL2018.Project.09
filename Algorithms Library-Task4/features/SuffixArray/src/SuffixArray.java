/**
*
* @author Toghrul
*/
import java.util.Arrays;

import queryupdate.SegmentTree;
import queryupdate.SparseTable;


public class SuffixArray {
	// Configuration class for suffix Tree
	
	public String algo = "";
    public int[][] suffixrank;
    public Tuple[] T;
    public int[] lcp;
    public int n;
    public int stp;

    public class Tuple implements Comparable<Tuple> {

        public int orgigindex;
        public int firstHalf, secondHalf;

        @Override
        public int compareTo(Tuple t) {
            if (this.firstHalf == t.firstHalf) {
                return Integer.compare(this.secondHalf, t.secondHalf);
            } else {
                return Integer.compare(this.firstHalf, t.firstHalf);
            }
        }
    }

    public SuffixArray(String s, String algo) {
    	this.algo = algo;
        n = s.length();
        suffixrank = new int[30][n];
        T = new Tuple[n];

        for (int i = 0; i < n; i++) {
            suffixrank[0][i] = s.charAt(i) - 'a';
            T[i] = new Tuple();
        }
        for (int cnt = 1, stp = 1; cnt < n; cnt *= 2, stp++) {
            this.stp = stp;
            for (int i = 0; i < n; i++) {
                T[i].firstHalf = suffixrank[stp - 1][i];
                T[i].secondHalf = i + cnt < n ? suffixrank[stp - 1][i + cnt] : -1;
                T[i].orgigindex = i;
            }
            Arrays.sort(T);
            suffixrank[stp][T[0].orgigindex] = 0;
            for (int i = 1, currRank = 0; i < n; i++) {
                if (T[i].firstHalf != T[i - 1].firstHalf || T[i].secondHalf != T[i - 1].secondHalf) {
                    currRank++;
                }
                //System.out.println(stp + " " + cnt);
                suffixrank[stp][T[i].orgigindex] = currRank;
            }
        }
        computeLCP(s);

    }

    public void computeLCP(String s) {
        lcp = new int[n];
        lcp[0] = 0;
        int h = 0;
        for (int i = 0; i < n; i++) {
            if (suffixrank[stp][i] != 0) {
                int j = T[suffixrank[stp][i] - 1].orgigindex;
                while (i + h < n && j + h < n && s.charAt(i + h) == s.charAt(j + h)) {
                    h++;
                }
                lcp[suffixrank[stp][i]] = h;
                if (h > 0) {
                    h--;
                }
            }
        }

    }

    public int getPreffix(int i, int j) {
    	int l = suffixrank[stp][i], r = suffixrank[stp][j];
        if (l > r) {
            int tmp = l;
            l = r;
            r = tmp;
        }
        if(l == r) return n - i;
        System.out.println(12);
    	Integer[] a = new Integer[lcp.length];
    	
    	for(int k = 0; k < a.length; k++) a[k] = lcp[k];
    	
    	if(this.algo.equals("SegmentTree")) {
    		SegmentTree<Integer> T = new SegmentTree<Integer>(a, Integer.MIN_VALUE) {

    			@Override
    			public Object merge(Object t2, Object t3) {
    				// TODO Auto-generated method stub
    				Integer a = (Integer)t2;
    				Integer b = (Integer)t3;
    				return Math.max(a, b);
    			}
    			
    			
    		};
    		
    	}else if(this.algo.equals("SparseTable")) {
            SparseTable<Integer> ST = new SparseTable<Integer>(a) {

    			@Override
    			public Integer merge(Object a, Object b) {
    				// TODO Auto-generated method stub
    				Integer x  = (Integer)a;
    				Integer y  = (Integer)b;
    				return Math.min(x, y);
    			}
            	
    		};
            
            return ST.get(l + 1, r);
    	}
    	return 0;

    }
    public long disticsubstring() {
        long ans = this.n - this.T[0].orgigindex;
        for(int i = 1; i < this.n; i++) {
            ans += (this.n - this.T[i].orgigindex - this.lcp[i]);
        }
        return ans;
    }
}