import java.util.HashMap;
import java.util.Map;

public class MainMostFrequentlyOccurringItemInArray {
	public static void main(String args []){
	       int [] array = {1,3,1,3,2,1,2,2,2};
	       System.out.println(mostFrequent(array));
	   }
	 
	   public static int mostFrequent(int [] array){
	       int mostFrequent = array[0];
	       int maxFrequency = 0;
	       Map<Integer, Integer> mapCount = new HashMap<>();
	       for (int i = 0; i < array.length; i++){
	           if (mapCount.get(array[i]) == null){
	               mapCount.put(array[i], 1);
	           } else {
	               mapCount.put(array[i], mapCount.get(array[i])+1);
	           }
	           if (maxFrequency < mapCount.get(array[i])){
	               maxFrequency = mapCount.get(array[i]);
	               mostFrequent = array[i];
	           }
	       }
	       return mostFrequent;
	   }

}
