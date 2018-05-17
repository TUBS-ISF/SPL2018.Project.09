package numbertheory;

public class Main {
	
	public static void main(String[] args) {
		BigInt a = new BigInt("12");
		BigInt b = new BigInt("12");
		
		BigInt c = a.multiply(b);
		
		c.print();

	}

}
