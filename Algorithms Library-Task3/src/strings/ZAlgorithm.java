package strings;

public class ZAlgorithm {

	int z[];
	public ZAlgorithm(String s) {
		z = new int[s.length()];
		int L = 0, R = 0;
		for(int i = 0; i < s.length(); i++) {
			if(i > R) {
				L = R = i;
				while(R < s.length() && s.charAt(R-L) == s.charAt(R)) R++;
				z[i] = R-L; R--;
			}else {
				int k = i - L;
				if(z[k] < R-i+1) z[i] = z[k];
				else {
					L = i;
					while(R < s.length() && s.charAt(R-L) == s.charAt(R)) R++;
					z[i] = R-L; R--;
				}
			}
		}
	}

}
