public class SegmentTreeLazy implements interfaces.ISegmentTreeLazy{
	int size;
	private int[] max;
	private int[] min;
	private int[] sum;

	private int[] lazy;


	public void init(int[] array){
		size = array.length;
		max=new int[array.length*4];
		min=new int[array.length*4];
		sum=new int[array.length*4];
		lazy=new int[array.length*4];
		buildTree(array,1,0,size-1);
	}

	private void buildTree(int[] array, int position, int l, int r){
		if(l==r){
			max[position]=array[l];
			min[position]=array[l];
			sum[position]=array[l];
			return;
		}
		buildTree(array, position*2,l,(l+r)/2);
		buildTree(array, position*2+1,(l+r)/2+1,r);

		merge(position,l,r);
	}

	private void merge(int position, int l, int r) {
		max[position]=Math.max(getMax(position*2),getMax(position*2+1) );
		min[position]=Math.min(getMin(position*2), getMin(position*2+1));
		sum[position]=getSum(position*2,l,(l+r)/2)+getSum(position*2+1,(l+r)/2+1,r);
	}

	private int getMax(int position){
		return max[position]+lazy[position];
	}

	private int getMin(int position){
		return min[position]+lazy[position];
	}

	private int getSum(int position,int l,int r){
		return sum[position]+lazy[position]*(r-l+1);
	}

	public int queryMax(int queryl, int queryr) {
		return queryMax(1,0,size-1,queryl,queryr);
	}

	public int queryMax(int position,int l,int r, int queryl, int queryr){
		if(l>=queryl&&queryr>=r){
			return getMax(position);
		}
		if(r<queryl||queryr<l){
			return Integer.MIN_VALUE;
		}
		push(position,l,r);
		int leftAns=queryMax(position*2,l,(l+r)/2,queryl,queryr);
		int rightAns=queryMax(position*2+1,(l+r)/2+1,r,queryl,queryr);
		return Math.max(leftAns, rightAns);
	}

	public int queryMin(int queryl, int queryr) {
		return queryMin(1,0,size-1,queryl,queryr);
	}

	private int queryMin(int position,int l,int r, int queryl, int queryr){
		if(l>=queryl&&queryr>=r){
			return getMin(position);
		}
		if(r<queryl||queryr<l){
			return Integer.MAX_VALUE;
		}
		push(position,l,r);
		int leftAns=queryMin(position*2,l,(l+r)/2,queryl,queryr);
		int rightAns=queryMin(position*2+1,(l+r)/2+1,r,queryl,queryr);
		return Math.min(leftAns, rightAns);
	}
	public int querySum(int queryl, int queryr) {
		return querySum(1,0,size-1,queryl,queryr);
	}

	private int querySum(int position,int l,int r, int queryl, int queryr){
		if(l>=queryl&&queryr>=r){
			return getSum(position,l,r);
		}
		if(r<queryl||queryr<l){
			return 0;
		}
		push(position,l,r);
		int leftAns=querySum(position*2,l,(l+r)/2,queryl,queryr);
		int rightAns=querySum(position*2+1,(l+r)/2+1,r,queryl,queryr);
		return leftAns+rightAns;
	}


	private void push(int position,int l, int r){
		lazy[position*2]+=lazy[position];
		lazy[position*2+1]+=lazy[position];
		max[position]=getMax(position);
		min[position]=getMin(position);
		sum[position]=getSum(position,l,r);
		lazy[position]=0;
		}

	public void update(int updatel, int updater, int value){
		update(1,0,size-1,updatel,updater,value);
	}

	private void update(int position, int l, int r, int updatel,int updater,int value){
		if(l>=updatel&&updater>=r){
			lazy[position]+=value;
			return;
		}
		if(r<updatel||updater<l){
			return;
		}
		push(position,l,r);
		update(position*2,l,(l+r)/2,updatel,updater,value);
		update(position*2+1,(l+r)/2+1,r,updatel,updater,value);
		merge(position,l,r);
	}
}