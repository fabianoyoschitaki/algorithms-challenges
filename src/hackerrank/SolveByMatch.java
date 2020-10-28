package hackerrank;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SolveByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> set = new HashSet<>();
        int result = 0;
        for (int i : ar) {
            if (set.contains(i)) {
                result++;
                set.remove(i);
            } else {
                set.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(sockMerchant(9, new int[] { 10, 20, 20, 10, 10, 30, 50, 10, 20 }));
    }
}
