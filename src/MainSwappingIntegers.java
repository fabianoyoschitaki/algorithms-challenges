
public class MainSwappingIntegers {
    public static void main(String[] args) {
        int a = 201;
        int b = 12;
        swapIntegersXOR(a, b);
    }
    
    /**
     * Won't work in all cases
     * 
     * @param a
     * @param b
     */
    public static void swapIntegers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println(a);
        System.out.println(b);
    }
    
    public static void swapIntegersXOR(int a, int b) {
        a = a ^ b;
        b = a ^ b;   // now a = b
        a = a ^ b;  // now b = a
        System.out.println(a);
        System.out.println(b);
    }
}
