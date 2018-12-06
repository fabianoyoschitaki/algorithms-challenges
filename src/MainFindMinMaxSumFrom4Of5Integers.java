import java.util.Arrays;
import java.util.Scanner;


public class MainFindMinMaxSumFrom4Of5Integers {
	private static final Scanner scan = new Scanner(System.in);
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int [] arr = new int[5];
		String[] arrItems = scan.nextLine().split(" ");
        for (int arrItr = 0; arrItr < 5; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }
        miniMaxSum(arr);
	}
	
	/**
	 * Prints the min sum value and the max sum value of 5 integers.
	 * @param arr
	 */
	private static void miniMaxSum(int[] arr) {
		Arrays.sort(arr);
		System.out.println(((long)arr[0] + (long)arr[1] + (long)arr[2] + (long)arr[3]) + " " + ((long)arr[1] + (long)arr[2] + (long)arr[3] + (long)arr[4]));
	}

}
