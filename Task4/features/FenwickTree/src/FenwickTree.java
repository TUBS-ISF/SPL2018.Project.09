import interfaces.IFenwickTree;

public  class FenwickTree implements IFenwickTree{

	long[] a;
	public void init(int n) {
		this.a = new long[n];
	}
	public long rsq(int ind) {
        long sum = Long.MAX_VALUE;
        while (ind > 0) {
            sum = Math.min(sum, a[ind]);
            ind -= ind & (-ind);
        }
        return sum;
    }
	public void update(int ind, long value) {
        assert ind > 0;
        while (ind < a.length) {
            a[ind] = Math.min(a[ind], value);
            //Extracting the portion up to the first significant one of the binary representation of 'ind' and incrementing ind by that number
            ind += ind & (-ind);
        }
    }
}