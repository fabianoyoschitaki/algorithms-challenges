package leetcode;

import java.util.Set;
import java.util.HashSet;

/**
 * https://leetcode.com/problems/happy-number/
 * https://www.youtube.com/watch?v=gW4hSbRoQoY
 * 
 * @author fabiano
 *
 */
public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();
        
        while (n != 1){
            int sum = 0;
            
            while (n != 0){
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            
            n = sum;
            if (seen.contains(n)){
                return false;
            }
            seen.add(n);
            
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
        System.out.println(new HappyNumber().isHappy(0));
    }
}
