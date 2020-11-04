package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/minimum-distances/problem
 * 
 * @author fabiano
 *
 */
public class MinimumDistances {

    // Complete the minimumDistances function below.
    static int minimumDistances(int[] a) {
        int minimumDistance = -1;
        Map<Integer, Integer> mapNumberToIndex = new HashMap<>();
        for (int i = 0; i < a.length ; i++){
            if (!mapNumberToIndex.containsKey(a[i])){
                mapNumberToIndex.put(a[i], i);
            } else {
                // Calculate distance between like numbers
                int tempDistance = i - mapNumberToIndex.get(a[i]);
                if (tempDistance < minimumDistance || minimumDistance == -1){
                    minimumDistance = tempDistance;
                }
                // Set new start point to the old end point
                mapNumberToIndex.put(a[i], i);
            }
        }
        return minimumDistance;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int result = minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

