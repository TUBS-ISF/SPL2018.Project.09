package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;




//test
public aspect Triea {
	pointcut gh(String s) :
		 (call(* Trie.deletep(..))) && args(s);

	before(String s) : gh(s) {
		Trie T = (Trie)thisJoinPoint.getTarget();
		if(T.root == null) {
			try {
				throw new Exception("Trie is not initialized");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		T.print(T.root);
		System.out.println("Deleted");
	}
}
