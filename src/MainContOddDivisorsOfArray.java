
public class MainContOddDivisorsOfArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(countSum(new int[]{45})); 
	}
	
	static long countSum(int[] numbers) {
		long result = 0;
		for (int number : numbers){
			System.out.println("Checking number: " + number);
			int tempSum = 1;
			// while it's even, make it odd
			while (number % 2 == 0){
				number = number / 2;
			}
			System.out.println("After dividing: " + number);
			System.out.println("Math.sqrt(" + number + ") = " + Math.sqrt(number));
			for (int i = 3; i <= Math.sqrt(number); i++){
				System.out.println(i + " <= " + Math.sqrt(number));
				int cTerm = 1;
				int cSum = 1;
				
				while (number % i == 0){
					System.out.println(number + " % " + i + " == 0");
					number = number/i;
					System.out.println("number = "+ number);
					cTerm *= i;
					System.out.println("cTerm = " + cTerm);
					cSum += cTerm;
					System.out.println("cSum  = " + cSum);
				}
				tempSum *= cSum;
			}
			if (number >= 2){
				System.out.println(number + " >= 2, so " + tempSum + " *= (1 + " + number + ")");
				tempSum *= (1 + number);
			}
			System.out.println("Final sum for " + number + ": " + tempSum);
			result += tempSum;
		}      
		return result;
	}
}
