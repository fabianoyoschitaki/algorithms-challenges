
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class MainIntervalMaxOverlap {
	static int [][] intervals;
	
	public static void main(String[] args) {
		int intervalNumbers = 10000;
		if (args.length == 1){
			intervalNumbers = Integer.parseInt(args[0]);
		}
		initIntervals(intervalNumbers);
		
		long ini = System.currentTimeMillis();
		System.out.println("Maxoverlap sorting: " + sorting() + " => Processing time took " + (System.currentTimeMillis() - ini) + " ms");
		
		ini = System.currentTimeMillis();
		System.out.println("Maxoverlap hashMap: " + hashMap() + " => Processing time took " + (System.currentTimeMillis() - ini) + " ms");
	}

	private static void initIntervals(int intervalNumbers) {
		intervals = new int[intervalNumbers][2];
		Random r = new Random();
		for (int i = 0; i < intervalNumbers; i++){
			int start = r.nextInt(10000000);
			int end = start + r.nextInt(100000);
			intervals[i][0] = start;
			intervals[i][1] = end;
		}
		System.out.println("\n\n==============================\nNumber of Intervals: " + intervals.length + "\n==============================");
	}

	private static int sorting() {
		int [] start = new int[intervals.length];
		int [] end = new int[intervals.length];
		for (int cont = 0; cont < intervals.length; cont++){
			start[cont] = intervals[cont][0];
			end[cont] = intervals[cont][1];
		}
		
		int maxOverlap = 0;
		int currentOverlap = 0;
		
		Arrays.sort(start);
		Arrays.sort(end);
		
		int i = 0;
		int j = 0;
		
		while (i < start.length && j < end.length){
			if (start[i] <= end[j]){
				currentOverlap++;
				maxOverlap = Math.max(maxOverlap, currentOverlap);
				i++;
			} else {
				currentOverlap--;
				j++;
			}
		}
		return maxOverlap;
	}

	private static int hashMap() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < intervals.length; i++){
			int [] current = intervals[i];
			for (int content = current[0]; content <= current[1]; content++){
				if (map.containsKey(content)){
					map.put(content,  map.get(content) + 1);
				} else {
					map.put(content, 1);
				}
			}
		}
		int maxOverlap = 0;
		for (Integer key : map.keySet()){
			if (map.get(key) > maxOverlap) {
				maxOverlap = map.get(key);
			}
		}
		return maxOverlap;
	}
}
