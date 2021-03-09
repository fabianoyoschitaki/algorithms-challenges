package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/gem-stones/problem
 * 
 * @author fabiano
 *
 */
public class Gemstones {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int gems = 0;
        short[] alphabet = new short[26];

        for (String word : arr) {
            boolean[] has = new boolean[26];
            for (char c : word.toCharArray()) {
                if (!has[c - 'a'])
                    alphabet[c - 'a']++;
                has[c - 'a'] = true;
            }
        }
        for (short n : alphabet) {
            if (n == arr.length)
                gems++;
        }
        return gems;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
