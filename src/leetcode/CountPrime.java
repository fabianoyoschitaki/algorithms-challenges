package leetcode;

/**
 * https://leetcode.com/problems/count-primes/
 * 
 * @author fabiano
 *
 */
public class CountPrime {
    public int countPrimes(int n) {
        boolean [] primes = new boolean[n];
        // assuming all numbers are prime
        for (int i = 2; i < primes.length; i++) {
            primes[i] = true;
        }
        
        // checking for non-primes. 
        // Any non-prime number will always have a factor that is less than or equal to its square root.
        // For example, pick 36.
        // It's factors are - 1*36, 2*18, 3*12, 4*9, 6*6. In each case, there is at least one number satisfying the above condition. 
        // So here, by considering all numbers up to the square root of n, we can successfully eliminate the non-prime numbers up to n. 
        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                System.out.println("Checking " + i + " because it's prime.");
                for (int j = i; j * i < primes.length; j++) {
                    System.out.println(i + "X" +  j + " is not prime because it's multiple of " + i);
                    primes[i * j] = false;
                }
            } else {
                System.out.println("Not checking " + i + " because it's already not prime.");
            }
        }
        
        int count = 0;
        for (boolean b : primes) {
            if (b) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new CountPrime().countPrimes(100));
    }
}
