package com.topcoder;

public class TaleOfThreeCities {
	
	public double connect(int[] ax, int[] ay, int[] bx, int[] by, int[] cx, int[] cy){
	    
		//min distance between a and b
	    double minDistanceAB = Integer.MAX_VALUE;
	    for(int i = 0; i < ax.length; i++){    	
	        int xa = ax[i];
	        int ya = ay[i];        
	        for(int j = 0; j < bx.length; j++){        
	            int xb = bx[j];
	            int yb = by[j];            
	            double distance = Math.sqrt((xa - xb) * (xa - xb) + (ya - yb) * (ya - yb));
	            if(distance < minDistanceAB){
	            	minDistanceAB = distance;	
	            }            
	        }
	    }
	    
	    System.out.println(minDistanceAB);
	    //min distance between b and c
	    double minDistanceBC = Integer.MAX_VALUE; 
	    for(int i = 0; i < bx.length; i++){    	
	        int xb = bx[i];
	        int yb = by[i];        
	        for(int j = 0; j < cx.length; j++){        
	            int xc = cx[j];
	            int yc = cy[j];            
	            double distance = Math.sqrt((xb - xc) * (xb - xc) + (yb - yc) * (yb - yc));
	            if(distance < minDistanceBC){
	            	minDistanceBC = distance;	
	            }            
	        }
	    }      
	    
	    System.out.println(minDistanceBC);
	    //min distance between b and c
	    double minDistanceCA = Integer.MAX_VALUE;
	    
	    for(int i = 0; i < cx.length; i++){    	
	        int xc = cx[i];
	        int yc = cy[i];        
	        for(int j = 0; j < ax.length; j++){        
	            int xa = ax[j];
	            int ya = ay[j];            
	            double distance = Math.sqrt((xc - xa) * (xc - xa) + (yc - ya) * (yc - ya));
	            if(distance < minDistanceCA){
	            	minDistanceCA = distance;	
	            }            
	        }
		}        
	    System.out.println(minDistanceCA);
	    
	    double min = Integer.MAX_VALUE;
	    
	    if(min > minDistanceCA){
	    	min = minDistanceCA;
	    }
	    
	    if(min > minDistanceAB){
	    	min = minDistanceAB;
	    }
	    
	    if(min > minDistanceBC){
	    	min = minDistanceBC;
	    }
	    
	    double secondMin = Integer.MAX_VALUE;
	    
	    if(minDistanceCA > min && minDistanceCA < secondMin){
	    	secondMin = minDistanceCA;
	    }
	    
	    if(minDistanceAB > min && minDistanceAB < secondMin){
	    	secondMin = minDistanceAB;
	    }
	    
	    if(minDistanceBC > min && minDistanceBC < secondMin){
	    	secondMin = minDistanceBC;
	    }
	    
	    return min + secondMin; 
	}
	
	public static void main(String[] args){
		
//		int[] ax = {0,0,0};
//		int[] ay = {0,1,2};
//		int[] bx = {2,3};
//		int[] by = {1,1};
//		int[] cx = {1,5};
//		int[] cy = {3,28};

		int[] ax = {-2,-1,0,1,2}; 
		int[] ay = {0,0,0,0,0};
		int[] bx = {-2,-1,0,1,2}; 
		int[] by = {1,1,1,1,1};
		int[] cx = {-2,-1,0,1,2};
		int[] cy = {2,2,2,2,2};
		
		
		
		TaleOfThreeCities obj = new TaleOfThreeCities();
		double returnVal = obj.connect(ax, ay, bx, by, cx, cy);
		
		System.out.println("Distance: " + returnVal);
		
	}

}
