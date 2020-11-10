package hackerrank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/taum-and-bday/problem
 * 
 * @author fabiano
 *
 */
public class TaumAndBday {

    /*
     * Complete the 'taumBday' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER b
     *  2. INTEGER w
     *  3. INTEGER bc
     *  4. INTEGER wc
     *  5. INTEGER z
     */

    public static long taumBday(int b, int w, int bc, int wc, int z) {
        if (Math.abs(bc-wc) <= z)
            return (long)b*bc + (long)w*wc;
        if (bc < wc){
            return (long)b*bc + (long)w*bc + (long)w*z;
        } else {
            return (long)b*wc + (long)w*wc + (long)b*z;
        }
    }


    public static void main(String[] args) throws IOException {
        System.out.println(taumBday(1000000000, 1000000000, 1000000000, 1000000000, 1));
    }
}

