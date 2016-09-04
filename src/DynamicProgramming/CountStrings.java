package DynamicProgramming;

public class CountStrings {
	
	/*
	 * Given a length n, return the number of strings of length n that can be made up of the letters 'a', 'b', and 'c', 
	 * where there can only be a maximum of 1 'b's and can only have up to two consecutive 'c's
	 */

	public int paintFenceWays(int n,int k){
		int[] dp = {0, k, k*k, 0};
		
		if(n <= 2){
			return dp[n];
		}
		
		for(int i = 2;i < n; i++){
			dp[3] = (k-1) * (dp[2] + dp[1]);
			dp[1] = dp[2];
			dp[2] = dp[3];
 		}
		
		return dp[3];
	}
	
	public int countStrings(int n){
		int noB = notMoreThan2C(n);
		int oneB = n * notMoreThan2C(n-1);
		return noB + oneB;
	}
	
	public int notMoreThan2C(int n){
		int consecutiveCs = paintFenceWays(n, 2); // strings with only 'a' and 'c' with no more than two consecutive same chars
		int allPossibilities = (int) Math.pow(2, n);// strings with only 'a' and 'c'
		
		return (allPossibilities - (allPossibilities -consecutiveCs ) / 2); // no more than 2 consecutive 'c's
	}
	
	
	public static void main(String[] args){
		CountStrings countStrings = new CountStrings();
		int count = countStrings.countStrings(3);
		System.out.println(count);
	}
		
	
}
