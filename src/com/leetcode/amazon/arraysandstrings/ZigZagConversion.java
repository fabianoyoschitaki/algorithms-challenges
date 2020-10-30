package com.leetcode.amazon.arraysandstrings;

import java.util.Arrays;

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        // edge case when numRows is 1, which the answer is exactly the same input s
        if (numRows == 1)
            return s;
        
        String[] lines = new String[numRows];
        Arrays.fill(lines, "");
        boolean goingDown = true;
        int currentLine = 0;
        for (int i = 0; i < s.length(); i++){
            lines[currentLine] += s.charAt(i);
            if (goingDown){
                if (currentLine+1 < numRows){
                    currentLine++;
                } else {
                    goingDown = false;
                    currentLine += -1;
                }
            } else {
                if (currentLine-1 >= 0){
                    currentLine--;
                } else {
                    goingDown = true;
                    currentLine += 1;
                }
            }
        }
        return String.join("", lines);
    }
    
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
