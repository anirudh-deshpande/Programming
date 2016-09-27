package misc;

public class TrailingZerosFactorial {
	
	//	172 Factorial Trailing Zeroes  
 
	public int trailingZeros(int n){
		int count = 0;
		
		while(n > 0){
			count += n/5;
			n = n/5; 
		}
		
		return count;
	}
	
	public static void main(String[] args){
		int n = 25;
		
		System.out.println(new TrailingZerosFactorial().trailingZeros(n));
	}
}
