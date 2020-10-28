package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.hackerrank.com/challenges/counting-valleys/problem
 * 
 * @author fabiano
 *
 */
public class CountingValleys {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */
    public static int countingValleys(int steps, String path) {
        int valleys = 0;
        int currentLevel = 0;
        boolean hasEnteredValley = false;
        for (int i = 0; i < steps; i++){
            char c = path.charAt(i);
            if (c == 'U'){
                currentLevel++;
                if (currentLevel == 0 && hasEnteredValley){
                    valleys++;
                    hasEnteredValley = false;
                }
            } else {
                if (currentLevel == 0){
                    hasEnteredValley = true;
                }
                currentLevel--;
            }
        }
        return valleys;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = CountingValleys.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}

