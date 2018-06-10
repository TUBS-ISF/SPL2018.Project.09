package queryupdate;

import java.lang.reflect.Array;

public abstract class FenwickTree <T>{

	T[] a;
	T NEUTRAL;
	public FenwickTree(Class<T> c, int n) {
		@SuppressWarnings("unchecked")
        final T[] a = (T[]) Array.newInstance(c, n);
        this.a = a;
	}
	public abstract T add(T a, T b);
	public T rsq(int ind) {
        T sum = NEUTRAL;
        while (ind > 0) {
            sum = add(sum, a[ind]);
            ind -= ind & (-ind);
        }
        return sum;
    }
	public void update(int ind, T value) {
        assert ind > 0;
        while (ind < a.length) {
            a[ind] =add(a[ind], value);
            //Extracting the portion up to the first significant one of the binary representation of 'ind' and incrementing ind by that number
            ind += ind & (-ind);
        }
    }
}
