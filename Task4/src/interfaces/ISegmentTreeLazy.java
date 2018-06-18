package interfaces;

public interface ISegmentTreeLazy {
	public void init(int[] a);
	public int queryMin(int queryl, int queryr);
	public int queryMax(int queryl, int queryr);
	public int querySum(int queryl, int queryr);
}
