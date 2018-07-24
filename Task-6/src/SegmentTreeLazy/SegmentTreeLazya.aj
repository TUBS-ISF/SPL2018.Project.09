package SegmentTreeLazy;

import java.util.Scanner;

public aspect SegmentTreeLazya {
	pointcut gh() :
		 (call(* SegmentTreeLazy.updateRange(..)));

	after() : gh() {
		SegmentTreeLazy T = (SegmentTreeLazy)thisJoinPoint.getTarget();
		if(T.T == null) {
			try {
				throw new Exception("Tree is not initialized");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Scanner scan = new Scanner(System.in);
		System.out.println("Tree wurde modifiziert");
		System.out.println("would you like print it?");
		String s = scan.next();
		if(s.startsWith("y")) {
			T.print(1);
		}
	}
}
