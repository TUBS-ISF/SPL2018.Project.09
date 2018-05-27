package strings;

public class KMP {
	int []p;
	public KMP(String s) {
		p = new int[s.length()];
		p[0] = 0;
		int i = 1;
		int M = s.length();
		// length of the previous longest prefix suffix
		int len = 0;
		while(i < M) {
			if(p[i] == p[len]) {
				len++;
				p[i] = len;
				i++;
			}else {
				if(len != 0) len = p[len-1];
				else {
					p[i] = 0;
					i++;
				}
			}
		}
	}

}
