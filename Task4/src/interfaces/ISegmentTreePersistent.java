package interfaces;

public interface ISegmentTreePersistent {
	public int get(int id, int l, int r);
	public void init(int[] a);
	public void update(int id, int l, int v);
}
