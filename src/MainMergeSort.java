import java.util.Random;
import java.util.Date;

public class MainMergeSort {
    public static void main(String args[]) {
      int[] numbers = createRandomArray(10);
      System.out.println(numbers.length);
      
      System.out.println("\nBefore Merge Sort:");
      for (int i : numbers){
          System.out.print(i + ", ");
      }
      
      mergeSort(numbers);
      
      System.out.println("\nAfter Merge Sort:");
      for (int i : numbers){
          System.out.print(i + ", ");
      }
    }
    
    public static void mergeSort(int[] numbers){
        // break recursion
        if (numbers.length == 1){
            return;
        }
        
        int middle = numbers.length/2;
        
        // fill arrays
        int[] left = new int[middle];
        int[] right = new int[numbers.length-middle];
        for (int i = 0; i < numbers.length; i++){
            if (i < middle){        
                left[i] = numbers[i];
            } else {
                right[i-middle] = numbers[i];
            }
        }
        
        // recursion
        mergeSort(left);
        mergeSort(right);
        
        // at this point they're recursively sorted, so sort again
        merge(numbers, left, right);
    }
    
    public static void merge(int[] numbers, int[] left, int[] right){
        int n = 0, l = 0, r = 0;
        for (; l < left.length && r < right.length; ){
            if (left[l] < right[r]){
                numbers[n++] = left[l++];
            } else {
                numbers[n++] = right[r++];
            }
        }
        for (; l < left.length; n++, l++){
            numbers[n] = left[l];
        }
        for (; r < right.length; n++, r++){
            numbers[n] = right[r];
        }
    }

    public static int[] createRandomArray(int size){
        int[] array = new int[size];
        
        Random r = new Random(new Date().getTime());
        for (int i = 0; i < size; i++){
            array[i] = r.nextInt(size*2);
        }
        return array;
    }
}
