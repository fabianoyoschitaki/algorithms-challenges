package codementor;

import java.util.List;
import java.util.Arrays;

public class CountChange {
    public static Integer countChange(Integer money, List<Integer> coins) {
        int countChanges = 0;

        int[][] temp = new int[coins.size() + 1][money + 1];
        temp[0][0] = 1;

        for (int i = 1; i <= coins.size(); i++) {
            temp[i][0] = 1;
            for (int j = 1; j <= money; j++) {
                temp[i][j] = temp[i - 1][j];
                if (j >= coins.get(i - 1)) {
                    temp[i][j] += temp[i][j - coins.get(i - 1)];
                }
            }
        }
        for (int i = 0; i < coins.size() + 1; i++) {
            for (int j = 0; j < money + 1; j++) {
                System.out.println("temp[" + i + "][" + j + "] is " + temp[i][j]);
            }
        }
        countChanges = temp[coins.size()][money];
        System.out.println("Answer: " + countChanges + "\n");
        return countChanges;
    }
    
    public static void main(String[] args) {
        System.out.println("here!");
        CountChange.countChange(4, Arrays.asList(1,2));
        CountChange.countChange(10,Arrays.asList(5,2,3));
    }
}
