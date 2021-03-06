
public class MainDynamicProgrammingFibonacci {

	static int EXECUTIONS;
	
	public static void main(String[] args) {
		Integer n = Integer.parseInt(args[0]);
		Integer [] fibCache = new Integer[n+1];
		System.out.println("Fib for " + n + " is: " + fibDyn(n, fibCache));
		for (int cont = 0; cont < fibCache.length; cont++) {
			System.out.println("Cached Fib for [" + cont + "] is: " + fibCache[cont]);
		}
		System.out.println("Cache size: " + fibCache.length);
		System.out.println("Total method calls: " + EXECUTIONS);
	}

	private static Integer fibDyn(int n, Integer[] fibCache) {
		EXECUTIONS++;
		if (fibCache[n] != null) return fibCache[n];
		return fibCache[n] = n <= 1 ? n : fibDyn(n-1, fibCache) + fibDyn(n-2, fibCache);
	}
}
