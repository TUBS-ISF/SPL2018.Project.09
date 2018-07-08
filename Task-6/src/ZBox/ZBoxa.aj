package ZBox;

import java.util.ArrayList;

public aspect ZBoxa {
	pointcut zboxa() :
		 (call(* ZBox.search(*,*)));

	 ArrayList<Integer> around() : zboxa() {
		ArrayList<Integer> L = proceed();
		if(L == null) {
			return new ArrayList<Integer>();
		}
		return L;
	}
}
