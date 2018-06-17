import java.util.List;

import interfaces.ISegmentTree;
import loader.PluginLoader;

public class Main {
	public static void main(String[] args) {
		
		List<ISegmentTree> messagePlugins = PluginLoader.load(ISegmentTree.class);
//		for(IMessage x : messagePlugins) {
//			System.out.println(x.getMessage());
//		}
		ISegmentTree T = messagePlugins.get(0);
		long[] a = new long[] {1,2,3,4};
		T.init(a);
		T.update(0, 12);
		System.out.println(T.get(0, 5));
	}
}
