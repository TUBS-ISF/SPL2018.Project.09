package KMP;

import java.util.ArrayList;

import Matcher.Matcher;

public aspect KMPA {
	pointcut aa() :
		 (call(* Matcher.Matcher.setPattern(..)));

	KMP around() : aa() {
		KMP a = proceed();
		a.computeLPSArray();
		return a;
	}

}
