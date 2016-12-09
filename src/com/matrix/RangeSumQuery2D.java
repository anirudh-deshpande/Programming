package com.matrix;

import java.util.Arrays;

public class RangeSumQuery2D {
	
	int[][] matrix;
    int[][] sumMatrix;

    public RangeSumQuery2D(int[][] matrix) {
        
        this.matrix = matrix;
        
        int m = matrix.length;
        int n;
        
        if(m == 0){
            n = 0;    
        }else{
            n = matrix[0].length;
        }
        
        int[][] rowPrefix = new int[m][n];    
        int[][] columnPrefix = new int[m][n];
            
        //rowPrefix [m][n]
        for(int i = 0; i < m; i++){
            rowPrefix[i][0] = matrix[i][0];
            for(int j = 1; j < n; j++){
                rowPrefix[i][j] = rowPrefix[i][j - 1] + matrix[i][j];
            }
        }
            
        //columnPrefix [m][n]
        for(int j = 0; j < n; j++){
            columnPrefix[0][j] = matrix[0][j];
            for(int i = 1; i < m; i++){
                columnPrefix[i][j] = columnPrefix[i - 1][j] + matrix[i][j];
            }
        }
            
        //sumMatrix [m + 1][n + 1]
        int[][] sumMatrix = new int[m + 1][n + 1];
            
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                sumMatrix[i][j] = 
                    sumMatrix[i - 1][j - 1] + 
                    (j - 2 < 0 ? 0:rowPrefix[i - 1][j - 2]) + 
                    (i - 2 < 0 ? 0:columnPrefix[i - 2][j - 1]) + 
                    matrix[i - 1][j - 1];
            }
        }
        
        for(int i = 0; i <= m; i++){
        	System.out.println(Arrays.toString(sumMatrix[i]));
        }
        
        
        this.sumMatrix = sumMatrix;    
    }
    

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(this.sumMatrix != null){
            int bigMatrixSum = this.sumMatrix[row2 + 1][col2 + 1];
            
            System.out.println("bigMatrixSum:" + bigMatrixSum);
            
            int smallMatrixSum = this.sumMatrix[row1][col1];
            
            System.out.println("smallMatrixSum:" + smallMatrixSum);
            
            int upMatrixSum = this.sumMatrix[row1][col2 + 1];
            
            System.out.println("upMatrixSum:"+upMatrixSum);
            
            int leftMatrixSum = this.sumMatrix[row2 + 1][col1]; 
            
            System.out.println("leftMatrixSum:"+leftMatrixSum);
            
            int subMatrixSum = (bigMatrixSum - smallMatrixSum) - (upMatrixSum - smallMatrixSum) - (leftMatrixSum - smallMatrixSum);            
            return subMatrixSum;            
        }else{
            return 0;
        }
    }
    
    public static void main(String[] args){
    	
    	int[][] matrix = {
    			{3,0,	1,4,	2},
    			{5,6,	3,2,	1},
    			{1,2,	0,1,	5},
    			
    			    	
    			{4,1,	0,1,	7},
    			{1,0,	3,0,	5}
    			};
    	
    	RangeSumQuery2D obj = new RangeSumQuery2D(matrix);
    	
    	int sum = obj.sumRegion(2, 1, 4, 3);
    	
    	System.out.println("Sum is: " + sum);
    	
    	
    }

}
