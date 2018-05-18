import numbertheory.Matrix;
import queryupdate.SegmentTree;
import queryupdate.SparseTable;

public class Main {
	

	public static void main(String[] args) {
		
		Integer[] a = new Integer[10000];
		for(int i = 0;i < a.length; i++) {
			a[i] = (int)(Math.random() * 100);
		}
		// Segment Tree for sum, min, max als with BigNum etc O(long(n)) 
		SegmentTree<Integer> T = new SegmentTree<Integer>(a, Integer.MIN_VALUE) {

			@Override
			public Object merge(Object t2, Object t3) {
				// TODO Auto-generated method stub
				Integer a = (Integer)t2;
				Integer b = (Integer)t3;
				return Math.max(a, b);
			}
			
			
		};
		// O(long n) time.
		T.update(0, 15);
		System.out.println(T.get(0, 5));
		
		// Sparse Table for range query min, max also with BigNum etc O(1) 
		SparseTable<Integer> ST = new SparseTable<Integer>(a) {

			@Override
			public Integer merge(Object x, Object y) {
				// TODO Auto-generated method stub
				Integer a = (Integer)x;
				Integer b = (Integer)y;
				//System.out.println(a + " " + b);
				return Math.max(a, b);
			}
			
		};
		// O(1) time
		System.out.println(ST.get(2,5));
		
		Integer[][] mm = {{1, 2}, {3, 4}};
		Matrix<Integer> M = new Matrix<Integer>(mm) {

			@Override
			public Integer ad(Object data2, Object data3) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer mul(Object data2, Object data3) {
				// TODO Auto-generated method stub
				return null;
			}
		};
		
		
	}

}