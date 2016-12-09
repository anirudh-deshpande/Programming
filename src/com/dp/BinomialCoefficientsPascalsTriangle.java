package com.dp;

public class BinomialCoefficientsPascalsTriangle {
	
	public void pascalsTriangle(int N){
		
		int[][] opt = new int[N][N];
		
		for(int i = 0; i < N; i++){
			
			// nC0 = 1 
			opt[i][0] = 1;
	
			// nCn = 1
			opt[i][i] = 1;
		}
		
		for(int i = 1; i < N; i++){
			for(int j = 1; j < i; j++){
				opt[i][j] = opt[i - 1][j - 1] + opt[i - 1][j];
			}
		}
		
		
		System.out.println(opt[42][7]);
		
		//Print
//		for(int i = 0; i < N; i++){
//			for(int j = 0; j < i; j++){
//				System.out.print(opt[i][j] + " ");
//			}
//			System.out.println();
//		}
	}
	
	public static void main(String[] args){
		
		new BinomialCoefficientsPascalsTriangle().pascalsTriangle(43);
		
	} 

}
