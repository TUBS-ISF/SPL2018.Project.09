package interfaces;

public interface ISuffixArray {
	public void init(String s);
	public void computeLCP(String s);
	public void getPreffix(int i, int j);
}
