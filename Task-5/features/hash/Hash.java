public class Hash {
	public static long[] pow;

    public static long[] getHashArray(String s) {
        long[] hash = new long[s.length()];
        long[] pow = new long[s.length()];
        hash[0] = s.charAt(0);
        pow[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            hash[i] = hash[i - 1] * 31 + s.charAt(i);
            pow[i] = pow[i - 1] * 31;
        }
        return hash;
    }

    public static long getHash(long[] hash, int l, int r) {
        if (l == 0) {
            return hash[r];
        }
        return hash[r] - hash[l - 1] * pow[r - l + 1];
    }
}