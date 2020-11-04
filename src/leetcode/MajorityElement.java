package leetcode;

import java.util.Map;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/majority-element/
 * 
 * @author fabiano
 *
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapNumberFrequency = new HashMap<>();
        
        for (int i : nums){
            int frequency = 1;
            if (mapNumberFrequency.containsKey(i))
                frequency = mapNumberFrequency.get(i) + 1;
            
            if (frequency > nums.length/2)
                return i;
            mapNumberFrequency.put(i, frequency);
        }
        
        throw new IllegalArgumentException("There's no major element");
    }
    
    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[] {3, 3, 3, 2, 1, 3, 4, 3, 2}));
    }
}
