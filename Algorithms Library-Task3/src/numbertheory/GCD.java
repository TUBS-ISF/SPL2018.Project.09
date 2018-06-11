package numbertheory;

public class GCD {

	public static long gcdextend(long a, long b, long[] X) {
		if (b == 0) {
			X[0] = 1;
			X[1] = 0;
			return a;
		} else {
			long d = gcdextend(b, a % b, X);
			long x = X[1];
			long y = X[0] - X[1] * (a / b);
			X[0] = x;
			X[1] = y;
			return d;
		}
	}

}
