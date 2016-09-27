package misc;

public class ReverseIntiger {
	
	public int reverse(int x) {
        
        int reverse = 0;
        
        while(x != 0){
            int rem = x % 10;
            int newReverse = reverse * 10 + rem;
            
            if((newReverse - rem) / 10 != reverse){
                return 0;
            }
            reverse = newReverse;
            
            x = x / 10;
        }
        
        return reverse;
        
    }

	public static void main(String[] args){
		int num = -1234;
		System.out.println(new ReverseIntiger().reverse(num));
	}

}
