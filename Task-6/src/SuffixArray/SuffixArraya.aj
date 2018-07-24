package SuffixArray;



public aspect SuffixArraya {
	pointcut gh() :
		 (call(* SuffixArray.*(..)));

	before() : gh() {
		SuffixArray T = (SuffixArray)thisJoinPoint.getTarget();
		updateHash(T);
	}
	void updateHash(SuffixArray SA) {
		System.out.print("Hash of Suffix array updated from " + SA.hash + " to ");
		SA.hash = 1;
		for(int i = 0; i < SA.S.length(); i++) {
			SA.hash = SA.hash * 31L + SA.S.charAt(i);
		}
		System.out.println(SA.hash);
	}
}
