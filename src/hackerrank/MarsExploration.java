package hackerrank;

/**
 * https://www.hackerrank.com/challenges/mars-exploration/problem
 * 
 * @author fabiano
 *
 */
public class MarsExploration {
    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int altered = 0;
        int i = 1;
        for (char c : s.toCharArray()){
            if (c != 'S' && (i % 3 == 0 || i % 3 == 1))
                altered++;
            else if (c != 'O' && i % 3 == 2)
                altered++;
            i++;
        }
        return altered;
    }
    
    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSPSSQSSOR"));
    }
}
