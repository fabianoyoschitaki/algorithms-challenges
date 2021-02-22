package hackerrank;

import java.io.IOException;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-squares
 * 
 * @author fabiano
 *
 */
public class SherlockAndSquares {

    // Complete the squares function below.
    static int squares(int a, int b) {
        int sqrtA = (int) Math.sqrt(a); // 5 = 2.121 - 2
        int sqrtB = (int) Math.sqrt(b); // 10 = 3.121 - 3
        if (sqrtA * sqrtA == a) {
            return (sqrtB - sqrtA) + 1;
        }
        return sqrtB - sqrtA;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(squares(4,4));
    }
}
