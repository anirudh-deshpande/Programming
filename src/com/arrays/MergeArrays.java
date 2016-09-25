package com.arrays;

import java.util.Arrays;

public class MergeArrays {
	
public void merge(int[] num1, int m, int[] num2, int n) {
        
        int i = 0; //For m
        int j = 0; //For n
        int k = 0; //For sorted
        
        if(n == 0){
            return;
        }
        
        if(m == 0){
        	if(n == 1){
        		num1[0] = num2[0];
                return;
        	}
        }
        
        int[] temp = new int[num1.length];
        
        while(i < m && j < n){
            if(num1[i] < num2[j]){
                temp[k] = num1[i];
                i++;
            }else{
                temp[k] = num2[j];
                j++;
            }    
            k++;
        }
        
        if(j == n){
            while(i < m){
                temp[k++] = num1[i++]; 
            }
        }
        
        
        if(i == m){
            while(j < n){
                temp[k++] = num2[j++]; 
            }
        }
        
        for(int a = 0; a < temp.length; a++){
            num1[a] = temp[a];
        }
        
        num1 = temp;
        
    }

	public void mergeLeetcode(int[] num1, int m, int[] num2, int n){
		int i = m - 1;
		int j = n - 1;
		int k = m + n - 1;
		
		while(i >= 0 && j >= 0){
			if(num1[i] > num2[j]){
				num1[k--] = num1[i--];
			}else{
				num1[k--] = num2[j--];
			}
		}
		
		while(j >= 0){
			num1[k--] = num2[j--];
			
		}
	}

	public static void main(String[] args){
		int[] num1 = {0,0,0,0,0};
		int m = 0;
		int[] num2 = {1,2,3,4,5};
		int n = 5;
		
		new MergeArrays().merge(num1, m, num2, n);
		System.out.println(Arrays.toString(num1));
		
		new MergeArrays().mergeLeetcode(num1, m, num2, n);
		System.out.println(Arrays.toString(num1));
	}

}
