package numbertheory;

public class Main {
	
	public static void main(String[] args) {
		BigInt a = new BigInt("99");
		BigInt b = new BigInt("99");
		
		BigInt c = a.multiply(b);
		
		c.print();
		// 8 * 10^3 + 1 * 10^2 + 1 * 10^1
	}

}
