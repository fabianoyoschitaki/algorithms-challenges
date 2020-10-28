package hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 * 
 * @author fabiano
 *
 */
public class RepeatedString {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long numberOfA = 0;
        if (n <= s.length()){
            for (int i = 0; i < n; i++){
                if (s.charAt(i) == 'a'){
                    numberOfA++;
                }
            }
        } else {
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == 'a'){
                    numberOfA += n/s.length();
                    if (i+1 <= n % s.length()){
                        numberOfA++;
                    }
                }
            }
        }
        return numberOfA;
    }

    public static void main(String[] args) throws IOException {
        String s = "aacaa";
        long n = 2;
        System.out.println(repeatedString(s, n));
        
    }
}

