package com.strings;

import java.util.HashSet;

public class LongestSubstringKChars {
	
	//Wrong answer
	
	private int longestSubstrKChars(String s, int k){
		
		HashSet<Character> set = new HashSet<>();
		int ans = 0;
		int i = 0;
		int num = 0;
		
		for(int j = 0; j < s.length(); j++){
			
			char c = s.charAt(j);
			if(!set.contains(c)){
				num++;
				set.add(c);
			}
			if(num > k){
				i = set.size();
				set.clear();
				num -= i;
			}
			ans = Math.max(ans, j - i + 1);
		}
		return ans;
	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            if (num > k) {
                while (--count[s.charAt(i++)] > 0);
                num--;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
	
	
	public static void main(String[] args){
		String s = "ababa3baba";
		
		System.out.println(new LongestSubstringKChars().lengthOfLongestSubstringKDistinct(s, 2));
		
	}

}
