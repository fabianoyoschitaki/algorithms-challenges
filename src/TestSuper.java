
public class TestSuper {
    private String a;

    public TestSuper() {
        System.out.println("here a: " + a);
    }
    
    public TestSuper(String a) {
        this();
        this.a = a;
    }
    
    public static void main(String[] args) {
        TestSuper testSuper = new TestSuper("b");
        System.out.println(testSuper.a);
    }
}  
