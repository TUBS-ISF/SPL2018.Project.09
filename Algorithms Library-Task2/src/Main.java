import numbertheory.BigInt;
import queryupdate.SegmentTree;

public class Main {
	

	public static void main(String[] args) {
		
		Integer[] a = new Integer[1000];
		for(int i = 0;i < a.length; i++) {
			a[i] = i;
		}
		// Segment Tree for sum, min, max etc
		SegmentTree<Integer> T = new SegmentTree<Integer>(a, Integer.MIN_VALUE) {

			@Override
			public Object merge(Object t2, Object t3) {
				// TODO Auto-generated method stub
				Integer a = (Integer)t2;
				Integer b = (Integer)t3;
				return Math.max(a, b);
			}
			
			
		};
		T.update(0, 15);
		System.out.println(T.get(0, 5));
		
	}

}