package com.dp;

import java.util.Arrays;

public class StringInterleaving {
	
	/* combined = "awbxcydz"
	 * str1 = "abcd"
	 * str2 = "wxyz"
	 * 
	 *  
	 *  opt[0][0] = true
	 *  
	 *  opt[0][j] = opt[0][j - 1] if combined[j - 1] = str1[j - 1]
	 *  
	 *  opt[i][0] = opt[i - 1][0] if combined[i - 1] = str2[i - 1]
	 *  
	 *  opt[i][j] = opt[i][j - 1] if combined[j - 1] = str1[j - 1] 
	 *  		  = opt[i - 1][j] if combined[i - 1] = str1[i - 1]	
	 * 
	 */
	
public boolean isInterleaveGood(String sa, String sb, String sc) {
        
        char[] str1 = sa.toCharArray();
        char[] str2 = sb.toCharArray();
        char[] str3 = sc.toCharArray();
        
        boolean T[][] = new boolean[str1.length +1][str2.length +1];
        
        if(str1.length + str2.length != str3.length){
            return false;
        }
        
        for(int i=0; i < T.length; i++){
            for(int j=0; j < T[i].length; j++){
                int l = i + j -1;
                if(i == 0 && j == 0){
                    T[i][j] = true;
                }
                else if(i == 0){
                    if(str3[l] == str2[j-1]){
                        T[i][j] = T[i][j-1];
                    }
                }
                else if(j == 0){
                    if(str1[i-1] == str3[l]){
                        T[i][j] = T[i-1][j];
                    }
                }
                else{
                    T[i][j] = (str1[i-1] == str3[l] ? T[i-1][j] : false) || (str2[j-1] == str3[l] ? T[i][j-1] : false);
                }
            }
        }
        return T[str1.length][str2.length];
    }

	public boolean interleavedStrings(char[] str1, char[] str2, char[] combined){
		
		int s1 = str1.length;
		int s2 = str2.length;
		
		if(s1 + s2 != combined.length){
			return false; 
		}
		
		boolean[][] opt = new boolean[s1 + 1][s2 + 1];
		
		for(int i = 0; i <= s1; i++){
			for(int j = 0; j <= s2; j++){
				int d = i + j - 1;
				if(i == 0 && j == 0){
					opt[i][j] = true;
				}else if(i == 0){
					if(combined[d] == str2[j - 1]){
						opt[i][j] = opt[i][j - 1]; 
					}
				}else if(j == 0){
					if(combined[d] == str1[i - 1]){
						opt[i][j] = opt[i - 1][j]; 
					}
				}else{
					
					//opt[i][j] = (str1[i-1] == combined[d] ? opt[i-1][j] : false) || (str2[j-1] == combined[d] ? opt[i][j-1] : false);
					if(combined[d] == str1[i - 1]){
						opt[i][j] = opt[i - 1][j];
					}
					
					else if(combined[d] == str2[j - 1]){
						opt[i][j] = opt[i ][j - 1];
					}
				}
			}
		}
		return opt[s1][s2];
	}
	
	
	//Leetcode
public boolean isInterleave(String s1, String s2, String s3) {
        
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        char[] combined = s3.toCharArray();
        
        int sA = str1.length;
        int sB = str2.length;
        
        if(sA + sB != combined.length){
            return false;
        }
        
        if(combined.length == 1){
            if(sA == 0 && sB != 0 && str2[0] == combined[0]) return true;
            else if(sB == 0 && sA != 0 && str1[0] == combined[0]) return true;
            else return false;
        }
        
        boolean[][] opt = new boolean[sB + 1][sA + 1];
        
        for(int i = 0; i <= sB; i++){
            for(int j = 0; j <= sA; j++){
                if(i == 0 && j == 0){
                    opt[i][j] = true;
                }
                else if(i == 0){
                    if(combined[j - 1] == str1[j - 1]){
                        opt[i][j] = opt[i][j - 1];    
                    }
                }
                else if(j == 0){
                    if(combined[i - 1] == str2[i - 1]){
                        opt[i][j] = opt[i - 1][j];
                    }
                }
                else{
                    if(combined[i + j - 1] == str2[i - 1]){
                        if(opt[i - 1][j] == true){
                            opt[i][j] = true;
                        }
                    }
                    else if(combined[i + j - 1] == str1[j - 1]){
                        if(opt[i][j - 1] == true){
                            opt[i][j] = true;
                        }
                    }
                }
            }
            
        }
        return opt[sB][sA];
    }
	
	
	
	public static void main(String[] args){
		
		StringInterleaving obj = new StringInterleaving();
		
		String combined = "babc";
		String str1 = "ab";
		String str2 = "bc";
		
		
		System.out.println(obj.interleavedStrings(str1.toCharArray(), str2.toCharArray(), combined.toCharArray()));
		System.out.println(obj.isInterleave(str1, str2, combined));
		System.out.println(obj.isInterleaveGood(str1, str2, combined));
		
		
	}
	
}
