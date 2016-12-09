package com.dp;

public class Fibonacci {
	
	private int getFibonacci(int n){
		if(n == 0)
			return 0;
		
		if(n == 1)
			return 1;
		
		return getFibonacci(n - 1) + getFibonacci(n - 2);
	}
	
	public long getFibonacciDP(int n){
		if(n == 0) return 0;
		if(n == 1) return 1;
		
		long[] fib = new long[n + 1];
		fib[0] = 0;
		fib[1] = 1;
		
		for(int i = 2; i <= n; i++){
			fib[i] = fib[i-1] + fib[i-2];
		}
		
		return fib[n];
		
	}
	
	public static void main(String[] args){
		//	System.out.println(new Fibonacci().getFibonacci(50));
		System.out.println(new Fibonacci().getFibonacciDP(50));
	}

}
