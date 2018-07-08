package Matcher;

import java.util.ArrayList;

public interface Matcher {
	public Matcher setPattern(String s);
	public ArrayList<Integer> search(String t);
}
