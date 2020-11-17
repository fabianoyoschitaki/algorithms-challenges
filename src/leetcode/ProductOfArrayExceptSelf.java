package leetcode;

/**
 * https://leetcode.com/explore/interview/card/amazon/76/array-and-strings/499/
 * 
 * Given an array nums of n integers where n > 1, return an array output such
 * that output[i] is equal to the product of all the elements of nums except
 * nums[i].
 * 
 * Example:
 * 
 * Input: [1,2,3,4] Output: [24,12,8,6]
 * 
 * Constraint: It's guaranteed that the product of the elements of any prefix or
 * suffix of the array (including the whole array) fits in a 32 bit integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up: Could you solve it with constant space complexity? (The output
 * array does not count as extra space for the purpose of space complexity
 * analysis.)
 * 
 */
public class ProductOfArrayExceptSelf {
    /**
     * Complexity analysis
     * 
     * Time complexity : O(N) where N represents the number of elements in the input
     * array. We use one iteration to construct the array L, one to construct the
     * array R and one last to construct the answer array using L and R. Space
     * complexity : O(N) used up by the two intermediate arrays that we constructed
     * to keep track of product of elements to the left and right.
     * 
     * @param nums
     * @return
     */
    public int[] productExceptSelfTimeONAndSpaceON(int[] nums) {

        // The length of the input array
        int length = nums.length;

        // The left and right arrays as described in the algorithm
        int[] L = new int[length];
        int[] R = new int[length];

        // Final answer array to be returned
        int[] answer = new int[length];

        // L[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so L[0] would be 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {

            // L[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all
            // elements to the left of index 'i'
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the
        // right,
        // so the R[length - 1] would be 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {

            // R[i + 1] already contains the product of elements to the right of 'i + 1'
            // Simply multiplying it with nums[i + 1] would give the product of all
            // elements to the right of index 'i'
            R[i] = nums[i + 1] * R[i + 1];
        }
        
        printArray("L:      ", L);
        printArray("R:      ", R);
        
        
        // Constructing the answer array
        for (int i = 0; i < length; i++) {
            // For the first element, R[i] would be product except self
            // For the last element of the array, product except self would be L[i]
            // Else, multiple product of all elements to the left and to the right
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
    
    public int[] productExceptSelfTimeONAndSpaceO1(int[] nums) {

        // The length of the input array 
        int length = nums.length;

        // Final answer array to be returned
        int[] answer = new int[length];

        // answer[i] contains the product of all the elements to the left
        // Note: for the element at index '0', there are no elements to the left,
        // so the answer[0] would be 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {

            // answer[i - 1] already contains the product of elements to the left of 'i - 1'
            // Simply multiplying it with nums[i - 1] would give the product of all 
            // elements to the left of index 'i'
            answer[i] = nums[i - 1] * answer[i - 1];
        }
        
        printArray("Answer: ", answer);
        // R contains the product of all the elements to the right
        // Note: for the element at index 'length - 1', there are no elements to the right,
        // so the R would be 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {

            // For the index 'i', R would contain the 
            // product of all elements to the right. We update R accordingly
            answer[i] = answer[i] * R;
            R *= nums[i];
        }

        return answer;
    }
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        
        int [] left = new int[n];
        int [] right = new int[n];
        
        left[0] = 1;
        for (int i = 1; i < n; i++){
            left[i] = left[i-1] * nums[i-1];
        }
        
        right[n-1] = 1;
        for (int i = n-2; i >= 0; i--){
            right[i] = right[i+1] * nums[i+1];
        }
        
        for (int i = 0; i < n; i++){
            nums[i] = right[i] * left[i];
        }
        return nums;
    }
    
    public static void main(String[] args) {
        int[] answer = new ProductOfArrayExceptSelf().productExceptSelf(new int[] {3,2,4,5,1,3,4});
        printArray("Answer: ", answer);
    }

    private static void printArray(String name, int[] answer) {
        System.out.print(name);
        for (int i : answer) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }
}
