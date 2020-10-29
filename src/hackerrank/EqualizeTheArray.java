package hackerrank;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem
 * 
 * @author fabiano
 *
 */
public class EqualizeTheArray {

    // Complete the equalizeArray function below.
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxRepetitions = 0;
        for (int i : arr){
            if (!map.containsKey(i)){
                map.put(i, 1);
            } else {
                map.put(i, map.get(i)+1);
            }
            if (map.get(i) > maxRepetitions){
                maxRepetitions = map.get(i);
            }
        }
        return arr.length - maxRepetitions;
    }

    public static void main(String[] args) throws IOException {
        int[] arr = new int[]{1, 2, 3, 4, 3, 4, 3, 1, 10};
        System.out.println(equalizeArray(arr));
    }
}

