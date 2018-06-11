import java.util.ArrayList;

public class ZAlgorithm {


	public static ArrayList<Integer> search(String pattern, String text) {
		String s = text + "$" + pattern;
		int[] z = new int[s.length()];
		int L = 0, R = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i > R) {
				L = R = i;
				while (R < s.length() && s.charAt(R - L) == s.charAt(R))
					R++;
				z[i] = R - L;
				R--;
			} else {
				int k = i - L;
				if (z[k] < R - i + 1)
					z[i] = z[k];
				else {
					L = i;
					while (R < s.length() && s.charAt(R - L) == s.charAt(R))
						R++;
					z[i] = R - L;
					R--;
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for(int i = 0; i < z.length; i++) {
			if(z[i] == pattern.length()) {
				//System.out.println("Pattern founded at index" + (i - pattern.length()-1));
				ans.add(i-pattern.length()-1);
			}
		}
		return ans;
	}

}

