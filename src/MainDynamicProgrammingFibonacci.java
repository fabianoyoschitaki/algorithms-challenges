
public class MainDynamicProgrammingFibonacci {

	static int CONT;
	
	public static void main(String[] args) {
		Integer n = 5;
		Integer [] fibCache = new Integer[n+1];
		System.out.println(fibDyn(n, fibCache));
		for (int cont = 0; cont < fibCache.length; cont++) {
			System.out.println("Fib for [" + cont + "] is: " + fibCache[cont]);
		}
		System.out.println("Cache size: " + fibCache.length);
		System.out.println("Total method calls: " + CONT);
	}

	private static Integer fibDyn(int n, Integer[] fibCache) {
		CONT++;
		System.out.println("fibDyn of " + n);
		if (n <= 1)
			return n;
		if (fibCache[n] != null) { 
			System.out.println("Cached!");
			return fibCache[n];
		} else {
			System.out.println("Not Cached!");
			fibCache[n] = fibDyn(n-1, fibCache) + fibDyn(n-2, fibCache);
			return fibCache[n];
		}
	}
}
