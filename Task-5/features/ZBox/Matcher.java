import java.util.ArrayList;

public class Matcher {

	protected ArrayList<Integer> search(String p, String t) {
		ArrayList<Integer> ans = new ArrayList<Integer>();
		String s = p + "$" + t;
		int n = s.length();
		int[] z = new int[n];
		z[0] = 0;
		for (int i = 1, l = 0, r = 0; i < n; i++) {
			if (i <= r)
				z[i] = Math.min(r - i + 1, z[i - l]);
			while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i]))
				z[i]++;
			if (i + z[i] - 1 > r) {
				l = i;
				r = i + z[i] - 1;
			}
		}
		for(int i = 0; i < n; i++) {
			if(z[i] == p.length()) ans.add(i-z[i]);
		}
		return ans;
	}

}