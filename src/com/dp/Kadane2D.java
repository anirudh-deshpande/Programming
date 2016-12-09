package com.dp;

public class Kadane2D {

	public class KadaneResult{
		int max_sum;
		int start;
		int end;
		
		public KadaneResult(int max_sum, int start, int end){
			this.max_sum = max_sum;
			this.start = start;
			this.end = end;
		}
	}
	
	private KadaneResult kadane1D(int[] nums){
	
		int global_optimum = nums[0];
		int local_optimum = nums[0];
		int N = nums.length;
		int start = 0;
		int end = 0;
		boolean startChanged = false;
		
		for(int i = 0; i < N; i++){
			if(local_optimum + nums[i] < nums[i]){
				local_optimum = nums[i];
				startChanged = true;
			}else{
				local_optimum = local_optimum + nums[i];
			}
			
			if(local_optimum > global_optimum){
				global_optimum = local_optimum;
				if(startChanged){
					start = i;
					startChanged = false;
				}
				end = i;
			}
		}
		
		return new KadaneResult(global_optimum, start, end);
	}
	
	
	
	public class Result{
		int maxSum;
		int leftBound;
		int rightBound;
		int upperBound;
		int lowerBound;
		
		@Override
		public String toString(){
			return "Result [maxSum=" + maxSum + ", leftBound=" + leftBound
                    + ", rightBound=" + rightBound + ", upBound=" + upperBound
                    + ", lowBound=" + lowerBound + "]";
		}
	}
	
	public Result maxSum(int [][] input){
		int rows = input.length;
		int columns = input[0].length;
		int[] temp = new int[rows];
		
		Result result = new Result();
		
		for(int left = 0; left < columns; left++){
			
			//Initialize the temp matrix
			for(int i = 0; i < rows; i++){
				temp[i] = 0;
			}
			
			for(int right = left; right < columns; right++){
				
				// Temp = temp + column 
				for(int i = 0; i < rows; i++){
					temp[i] += input[i][right];
				}
				
				KadaneResult kadaneResult = kadane1D(temp);
				
				if(kadaneResult.max_sum > result.maxSum){
					result.maxSum = kadaneResult.max_sum;
					result.leftBound = left;
					result.rightBound = right;
					result.lowerBound = kadaneResult.start;
					result.upperBound = kadaneResult.end;
				}
			}
		}
		return result;
	}
	
	
	
    public static void main(String args[]){
        int input[][] = {{ 2,  1, -3, -4,  5},
                         { 0,  6,  3,  4,  1},
                         { 2, -2, -1,  4, -5},
                         {-3,  3,  1,  0,  3}};
        Kadane2D saw = new Kadane2D();
        System.out.println(saw.maxSum(input));
    }
	
}
