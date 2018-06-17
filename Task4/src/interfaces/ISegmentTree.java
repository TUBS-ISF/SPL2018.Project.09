package interfaces;

public interface ISegmentTree {
	public void init(long[] a);
	public void update(int i, long v);
	public long get(int l, int r);
}
