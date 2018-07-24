package DoubleLinkedList;


public aspect DoubleLinkedLista {
	pointcut gh() :
		 (call(* DoubleLinkedList.delete(..)));
	pointcut re() :
		 (call(* DoubleLinkedList.reverse(..)));

	before() : gh() {
		DoubleLinkedList T = (DoubleLinkedList)thisJoinPoint.getTarget();
		if(T.head == null) {
			System.out.println("Lust musst have elements");
		}
	}
	
	before() : re() {
		DoubleLinkedList T = (DoubleLinkedList)thisJoinPoint.getTarget();
		DoubleLinkedList L2 = new DoubleLinkedList();
		for(Node i = T.head; i != null; i = i.next) {
			L2.insertStrat(i.data);
		}
		T = L2;
	}
}
