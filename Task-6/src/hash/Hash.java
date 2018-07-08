package hash;

import java.util.ArrayList;

import Matcher.Matcher;

public class Hash implements Matcher{

	public static long[] pow;
	public long[] hash;
    
    public void sayHello(String s) {
    	System.out.println("Hi, I am Hash class");
    }

    public long getHash(int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        return hash[r] - hash[l - 1] * pow[r - l + 1];
    }
	@Override
	public Matcher setPattern(String s) {
		hash = new long[s.length()];
        long[] pow = new long[s.length()];
        hash[0] = s.charAt(0);
        pow[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            hash[i] = hash[i - 1] * 31 + s.charAt(i);
            pow[i] = pow[i - 1] * 31;
        }
		return null;
	}

	@Override
	public ArrayList<Integer> search(String t) {
		long h = 1;
		for(int i =0; i < t.length(); i++)
			h *= t.charAt(i);
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < hash.length; i++) {
			if(h == this.getHash(i, i+t.length()-1)) {
				ans.add(i);
			}
		}
		return ans;
	}

}
