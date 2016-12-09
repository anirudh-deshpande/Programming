package com.dp;

public class LongestPalindromicSubstring {
	
	public void palSubstring(char[] str){
		
		int N = str.length;
		boolean[][] opt = new boolean[N][N];
		int max_len = 1;
		int begin_index = 0;
		int palindrome_count = 0;
		
		
		for(int i = 0; i < N; i++){
			opt[i][i] = true;
			max_len = 1;
			begin_index = i;
			palindrome_count++;
		}
		
		for(int i = 0; i < N - 1; i++){
			if(str[i] == str[i + 1]){
				opt[i][i + 1] = true;
				max_len = 2;
				begin_index = i;
			}
		}
		
		
		for(int d = 3; d <= N; d++){
			
			for(int i = 0; i < N - d + 1; i++){
				
				int j = i + d - 1;
				
				if(str[i] == str[j]){
					if(opt[i + 1][j - 1] == true){
						opt[i][j] = true;
						begin_index = i;
						max_len = d;
					}
				}
			}
		}
		System.out.println(new String(str).substring(begin_index, begin_index + max_len));
		System.out.println("Palindrome count: "+palindrome_count);
	}
	
	
	/*
	 * 	"eabcb"
	 * 
	 * 
	 * public class Solution {
    public String longestPalindrome(String s) {
        
        if(s.length() == 1){
            return s;
        }
            
        
        int N = s.length();
        int max_length = 0;
        int start_index = 0;
        
        boolean[][] opt = new boolean[N][N];
        
        for(int i = 0; i < N; i++){
            opt[i][i] = true;
            start_index = i;
            max_length = 1;
        }
        
        for(int d = 2; d <= N; d++){
            for(int i = 0; i < N - d + 1; i++){
                int j = i + d - 1;
                
                if(d == 2 && s.charAt(i) == s.charAt(j))
                {
                    opt[i][j] = true;
                    start_index = i;
                    max_length = d;
                }                
                
                if(s.charAt(i) == s.charAt(j)){
                    if(opt[i + 1][j - 1] == true){
                        opt[i][j] = true;
                        
                        int cur_length = d - i;
                        if(cur_length > max_length){
                            max_length = d;
                            start_index = i;
                        }
                    }
                }
                else{
                        opt[i][j] = opt[i + 1][j] || opt[i][j - 1];
                }
            }
            
        }
        
        if(max_length == N){
            return s;
        }
        
        return s.substring(start_index, max_length + 1);
        
    }
}
	 */
	
	
	public static void main(String[] args){
		String str = "scsdxxdsc";
		new LongestPalindromicSubstring().palSubstring(str.toCharArray());
	}

}
