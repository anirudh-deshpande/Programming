package com.strings;

public class MultiplyStrings {
	
	private String multiply(String s1, String s2){
		
		int l1 = s1.length();
		int l2 = s2.length();
		int[] res = new int[l1 + l2];
		
		for(int i = l1-1; i >= 0; i--){
			
			for(int j = l2-1; j >= 0; j--){
				
				int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
				int p1 = i + j;
				int p2 = i + j + 1;
				
				int sum = mul + res[p2];
				
				res[p1] += sum / 10;
				res[p2] = sum % 10;
				
			}
			
		}
		
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
		
	    StringBuilder sb = new StringBuilder();
	    for(int p : res) 
	    	if(!(sb.length() == 0 && p == 0)) 
	    		sb.append(p);
	    
	    System.out.println(sb.toString());
	    return sb.length() == 0 ? "0" : sb.toString();
		
	} 	
	
	public static void main(String[] args){
		MultiplyStrings multiply = new MultiplyStrings();
		
		System.out.println(multiply.multiply("23", "5"));
	}

}
