package hash;

import java.util.ArrayList;

public aspect Hash {
	void around(): execution(void Matcher.Matcher.search()) {
		System.out.println("around begin");
		//proceed();
		//System.out.println("around end");
	}
}
