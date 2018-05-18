import numbertheory.BigInt;
import queryupdate.SegmentTree;

public class Main {
	

	public static void main(String[] args) {
		
		Integer[] a = new Integer[100];
		for(int i = 0;i < a.length; i++) {
			a[i] = i;
		}
		SegmentTree<Integer> T = new SegmentTree<Integer>(a) {
			@Override
			public Integer merge(Integer t1, Integer t2) {
				
				return t1 + t2;
			}
		};
		T.update(0, 12);
		
	}

}