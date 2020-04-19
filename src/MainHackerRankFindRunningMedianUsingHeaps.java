import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Continuous median problem: You have an array of numbers that you're reading
 * in one after another and after each number you want to print the median of
 * all the numbers thus far.
 * 
 * - mean: average - median: middle in sorted order - mode: most common number
 * 
 * A median is the value in a list of numbers for which half of the numbers are
 * below and half are above. Odd size array: it's the midpoint: 1, 2, 3, [4], 5,
 * 6, 7 Even size array: it's the average of the two midpoints: 1, 2, [3], [4],
 * 5, 6 = 3.5
 * 
 * Brute force is O(n2) because for every new element in the array you have to
 * traverse it again to get the median
 * 
 * The best solution would be to have 2 buckets that should have the same size
 * (or max 1 difference)
 * 
 * Lowers: left bucket will be a MAX Heap (root node has the highest value) with
 * lowest values Highers: right bucket will be a MIN Heap (root node has the
 * lowest value) with highest values
 * 
 * if buckets same size: average(Lowers.max + Highers.min) if buckets have
 * different sizes: Lowers.max or Highers.min (for the bigger bucket)
 * 
 * @author fabiano
 *
 */
public class MainHackerRankFindRunningMedianUsingHeaps {
	public static void main(String[] args) {

	}

	public static double[] getMedians(int[] array) {
		// max heap
		PriorityQueue<Integer> lowers = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return -1 * o1.compareTo(o2);
			}
		});

		// min heap
		PriorityQueue<Integer> highers = new PriorityQueue<>();

		// the number of medians is the size of the array.
		double[] medians = new double[array.length];

		for (int i = 0; i < array.length; i++) {
			int currentNumber = array[i];
			// modularize your code! shows good styling, makes code easier to test and makes
			// code easier for you to write
			addNumber(currentNumber, lowers, highers);
			rebalance(lowers, highers);
			medians[i] = getMedian(lowers, highers);
		}
	}
}
