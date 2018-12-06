import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainMaxDegreeArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(degreeOfArray(new int[]{}));
	}

	/*
     * Complete the degreeOfArray function below.
     */
    static int degreeOfArray(int[] arr) {
    	if (arr == null || arr.length == 0){
    		return 0;
    	}
        int minDegree = Integer.MAX_VALUE;
        
        int [] originalCopy = new int[arr.length];
        System.arraycopy(arr, 0, originalCopy, 0, arr.length);
    	Arrays.sort(arr);
        
        int currentNumber = arr[0];
        List<Integer> highestDegreeNumbers = new ArrayList<Integer>();
        
        int tempOccurrences = 1;
        int maxOccurrences = 1;
        
        for (int pos = 1; pos < arr.length; pos++){
            if (currentNumber == arr[pos]){
                tempOccurrences++;
            } else {
                if (tempOccurrences > maxOccurrences){
                    maxOccurrences = tempOccurrences;
                    highestDegreeNumbers.clear();
                    highestDegreeNumbers.add(arr[pos-1]);
                } else if (tempOccurrences == maxOccurrences){
                	highestDegreeNumbers.add(arr[pos-1]);
                }
                currentNumber = arr[pos];
                tempOccurrences = 1;
            }
        }
        if (tempOccurrences > maxOccurrences){
        	maxOccurrences = tempOccurrences;
            highestDegreeNumbers.clear();
            highestDegreeNumbers.add(arr[arr.length-1]);
        } else if (tempOccurrences == maxOccurrences){
        	highestDegreeNumbers.add(arr[arr.length-1]);
        }
        
        if (maxOccurrences == 1){
        	return 1;
        }
        
        String arrToString = Arrays.toString(originalCopy).replace("[", " ").replace("]", ",");
        int tempDegree = minDegree;
        for (Integer integer : highestDegreeNumbers) {
        	String temp = arrToString.substring(arrToString.indexOf(" " + integer + ","), arrToString.lastIndexOf(" " + integer + ","));
			tempDegree = (temp.split(",").length + 1);
			if (tempDegree < minDegree){
				minDegree = tempDegree;
			}
		}
        return minDegree;
    }
}
