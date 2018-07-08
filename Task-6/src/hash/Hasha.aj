package hash;

import java.util.ArrayList;


public aspect Hasha{
	pointcut gha(int l, int r) :
		 (call(* Hash.getHash(..))) && args(l,r);

	before(int l, int r) : gha(l,r) {
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
