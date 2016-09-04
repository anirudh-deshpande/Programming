package DynamicProgramming;

public class PaintFence {
	
	public int noOfColors(int fences, int colors){
		int[] dp = {0, colors, colors*colors, 0};
		
		if(fences <= 2){
			return dp[fences];
		}
		
		for(int i=2; i<fences; i++){
			dp[3] = (colors - 1) * (dp[1] + dp[2]);
			dp[1] = dp[2];
			dp[2] = dp[3];
		}
		
		return dp[3];
	}
	
	
	
	public static void main(String[] args){
		PaintFence paintFence = new PaintFence();
		
		int total = paintFence.noOfColors(3, 3);
		
		System.out.println(total);
		
	}
	
}
