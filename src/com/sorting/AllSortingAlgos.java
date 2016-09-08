package com.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class AllSortingAlgos {

	
	public static final int RANGE =255;
	public static final int DIGITS = 6;
	
    public static String countingSort(String a){
        
    	a=a.toLowerCase();
        int[] count = new int[RANGE];
        char[] output = new char[a.length()];
        
        for(int i=0;i<a.length();i++){
            count[a.charAt(i)]++;
        }
        
        for(int i=1;i<RANGE;i++){
            count[i]+=count[i-1];
        }
        
        for(int i=0;i<a.length();i++){
            output[count[a.charAt(i)]-1]=a.charAt(i);
            count[a.charAt(i)]--;
        }
    
        return new String(output);
    
    }
    
    

    public static int getMax(int[] a){
    
        int max = a[0];
        
        for(int i=1;i<a.length;i++){
            if(a[i]>max)
                max=a[i];
        }
        
        return max;
    
    }
    
    
    public static void countForRadixSort(int[] a,int exp){
        
        int[] output = new int[a.length];
        int[] count = new int[DIGITS];
        Arrays.fill(count, 0);
        
        
        for(int i=0;i<a.length;i++){
            count[(a[i]/exp)%DIGITS]++;
        }
        
        for(int i=1;i<DIGITS;i++){
            count[i]+=count[i-1];
        }
        
        for(int i=a.length-1;i>=0;i--){
        
            output[count[(a[i]/exp)%DIGITS]-1] = a[i];
            count[(a[i]/exp)%DIGITS]--;
            
        }
        
        for(int i=0;i<a.length;i++){
            a[i]=output[i];
        }
        
        
    }

    public static int[] radixSort(int[] a){
    
        int max = getMax(a);
        
        for(int exp=1;max/exp>0;exp*=10){
            countForRadixSort(a,exp);
        }
        
        return a;
    
    }
    
    public static void sortedMerge(int[] a,int[] b){
    	int indexA=-1;
        for(int i=0;i<a.length;i++){
             if(a[i]!=0)
                indexA++;    
        }
        
        int indexB=b.length-1;
        int indexMerged = a.length-1;
        
        while(indexB>=0){
        
            if(indexA>=0 && a[indexA]>b[indexB]){
                a[indexMerged] = a[indexA];
                indexMerged--;
                indexA--;
            }else{
                a[indexMerged] = b[indexB];
                indexMerged--;
                indexB--;
            }
        
        }
    }
    
    public static String sortArr(String s){
    	
    	char[] cArr = s.toCharArray();
    	Arrays.sort(cArr);
    	return String.valueOf(cArr);
    	
    }
    
    public static void anagramGroup(String[] sArr){
    	
    	HashMap<String,List<String>> hs = new HashMap<>();
    	String key = null;
    	for(String s:sArr){
    		key=sortArr(s);
    		
    		if(hs.containsKey(key)){
    			hs.get(key).add(s);
    		}else{
    			List <String> lst = new ArrayList<>();
    			lst.add(s);
    			hs.put(key, lst);
    		}
    		
    	}
    	
    	int count = 0;
    	
    	for(String s:hs.keySet()){
    		for(String val:hs.get(s)){
    			sArr[count]=val;
    			count++;
    		}
    	}
    	
    }
    
    


    public static Boolean binarySearch(int[] a,int low,int high,int key){
    
        while(low<high){
            int mid=(low+high)/2;
            
            if(key==a[mid]){
                return true;
            }else if(key>a[mid]){
                binarySearch(a,mid+1,high,key);
            }else{
                binarySearch(a,low,mid-1,key);
            }
        }
        return false;
    }

    public static Boolean rotatedSearch(int[] a,int key){
        
        int low=0;
        int high=a.length-1;
        int mid;
        
        while(low<=high){
            mid=(low+high)/2;
            
            if(a[mid-1]>=a[mid] && a[mid]<=a[mid+1]){
                if(key==a[mid]){
                    return true;
                }else if(key>a[mid]){
                    binarySearch(a,low,mid-1,key);
                }else{
                    binarySearch(a,mid+1,high,key);
                }
                
            }if(a[mid]>a[mid+1] && a[high]<a[mid]){
                low=mid+1;
            }else{
                high=mid-1;
            }
            
        }
        
        return false;
    
    }
    
    public static Boolean rotatedSearch(int[] a,int key,int low,int high){
    	int mid = (low+high)/2;
    	if(key==a[mid]){
    		return true;
    	}

    	if(low>high){
    		return false;
    	}
    	//left side
    	if(a[low]<a[mid]){
    		if(key>=a[low] && key<=a[mid]){
    			return rotatedSearch(a,key,low,mid-1);
    		}else{
    			return rotatedSearch(a,key,mid+1,high);
    		}               
    	}else if(a[mid]<a[low]){
    		if(key>a[mid] && key<=a[high]){
    			return rotatedSearch(a,key,mid+1,high);
    		}else{
    			return rotatedSearch(a,key,low,mid-1);
    		}                 
    	}else if(a[low]==a[mid]){
    		if(a[mid]!=a[high]){
    			return rotatedSearch(a,key,mid+1,high);
    		}else{
    			Boolean result = rotatedSearch(a,key,low,mid-1);
    			if(result==false){
    				return rotatedSearch(a,key,mid+1,high);
    			}else{
    				return result;
    			}
    		}
    	}
    
    return false;

}
    
    
    public static int position(String[] strings, String key,int low,int high){
        
        if(high<low){
            return -1;
        }
        
        int mid=(low+high)/2;
        
        if(strings[mid].equals("")){
                int left=mid-1;
                int right=mid+1;
                
                while(true){
                
                    if(left<low && right>high){
                        return -1;
                    }else if(!strings[left].equals("")){
                        mid=left;
                        break;
                    }else if(!strings[right].equals("")){
                        mid=right;
                        break;                    
                    }
                    left--;
                    right++;
                
                }
        }
        
        if(key.equals(strings[mid])){
            return mid;
        }else if(strings[mid].compareTo(key)<0){
            return position(strings,key,mid+1,high);
        }else{
            return position(strings,key,low,mid-1);
        }
    }
    
    public static Boolean matrixFind(int[][] matrix,int key){
        
        int row=0;
        int col = matrix[0].length-1;
        
        while(row<matrix[0].length && col>=0){
        
            if(matrix[row][col]==key){
                return true;
            }else if(key<matrix[row][col]){
                col--;
            }else{
                row++;    
            }
        }
        return false;
    }
    
    public static void main(String[] args){
        
        String s = "AnirudhDeshpande";
        int[] a = {1000,990,5950,200,10};
        
        System.out.println(countingSort(s).toString());
        
        System.out.println(Arrays.toString(radixSort(a)));
    
        /*Sorted Merge*/
        
        int[] arr = new int[5];
        Arrays.fill(arr,0);
        
        int[] brr = new int[2];
        Arrays.fill(brr,0);     
        
        arr[0]=3;arr[1]=4;arr[2]=5;
        brr[0]=1;brr[1]=2;
        
        sortedMerge(arr,brr);
        
        System.out.println(Arrays.toString(arr));
        
        
        String[] sArr = {"acre","ram","care","rahim","race","raman","acer"};
        
        anagramGroup(sArr);
        
        System.out.println(Arrays.toString(sArr));
        
        
        int[] rArr = {5,6,7,1,2,3,4};
        
        System.out.println(rotatedSearch(rArr,4,0,rArr.length-1));
        
        String[] strings = {"Aditya","","","","","Anirudh","Damodar","Ruchika"};
        System.out.println(position(strings,"Damodar",0,strings.length-1));
        
        Scanner sc = new Scanner(System.in);
        
        int n=sc.nextInt();
        int[][] matrix = new int[n][n];
        
        for(int i=0;i<n;i++){
        	for(int j=0;j<n;j++){
        		matrix[i][j]=sc.nextInt();
        	}
        }
        
        int key = sc.nextInt();
        
        System.out.println(matrixFind(matrix,key));
        
        
    }
	
}

