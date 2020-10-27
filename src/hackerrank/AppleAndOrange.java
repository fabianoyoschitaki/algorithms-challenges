package hackerrank;

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem?h_r=next-challenge&h_v=zen
 * @author fabiano
 *
 */
public class AppleAndOrange {

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int appleResult = 0, orangeResult = 0;
        for (int apple : apples) {
            if (a + apple >= s && a + apple <= t) {
                appleResult++;
            }
        }
        for (int orange : oranges) {
            if (b + orange >= s && b + orange <= t) {
                orangeResult++;
            }
        }
        System.out.println(appleResult);
        System.out.println(orangeResult);
    }

    public static void main(String[] args) {
        int s = 7;
        int t = 10;

        int a = 4;
        int b = 12;

        int[] apples = new int[]{2,3,-4};
        int[] oranges = new int[] {3,-2,-4};

        countApplesAndOranges(s, t, a, b, apples, oranges);
    }
}

