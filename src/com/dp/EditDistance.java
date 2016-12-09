package com.dp;

import java.util.Arrays;

public class EditDistance {
	
	public int min(int a, int b, int c){
        return a < b && a < c ? a : b < c ? b : c;
    }
    
    public int minDistance(String word1, String word2) {
        
        char[] str1 = word1.toCharArray();
        char[] str2 = word2.toCharArray();
        
        int M = str1.length;
        int N = str2.length;
        int[][] opt = new int[M + 1][N + 1];
        
        // Initialize 0th column
        for(int j = 0; j <=N; j++){
            opt[0][j] = j;
        }
        
        // Initialize 0th row
        for(int i = 0; i <= M; i++){
            opt[i][0] = i;
        }
        
        for(int i = 1; i <= M; i++){
            for(int j = 1; j <= N; j++){
                if(str1[i - 1] == str2[j - 1]){
                    opt[i][j] = opt[i - 1][j - 1];
                }else{
                    opt[i][j] = 1 + min(opt[i - 1][j], opt[i][j - 1], opt[i - 1][j - 1]);
                }
            }
        }
        
        for(int i = 0; i <= M; i++){
        	System.out.println(Arrays.toString(opt[i]));
        }
        
        edits(opt, str1, str2);
        
        return opt[M][N];
    }
    
    public void edits(int[][] opt, char[] str1, char[] str2){
    	
    	int M = str1.length;
        int N = str2.length;
        
        while(M > 0 && N > 0){
        	
        	//Very very important
        	//if(opt[M][N] == opt[M - 1][N - 1]){
        	if(str1[M - 1] == str2[N - 1]){
        		M = M - 1;
        		N = N - 1;
        	}
        	else if(opt[M][N] == 1 + opt[M - 1][N - 1]){
        		System.out.println("Edit "+str1[M - 1]+" in "+new String(str1) + " to "+ str2[N - 1]);
        		M = M - 1;
        		N = N - 1;
        	}
        	else if(opt[M][N] == 1 + opt[M][N - 1]){
        		System.out.println("Delete "+str2[N - 1]+" from "+new String(str2));
        		N = N - 1;
        	}
        	else if(opt[M][N] == 1 + opt[M - 1][N]){
        		System.out.println("Delete "+str2[M - 1]+" from "+new String(str1));
        		M = M - 1;
        	}
        }
    	
    }
    
    public static void main(String[] args){
    	EditDistance dist = new EditDistance();
    	String word1 = "azced";
    	String word2 = "abcdef";
    	
    	System.out.println(dist.minDistance(word1, word2));
    	
    }

}
