package AbstractAndInterface;

public interface TestInterface {
    default void defaultMethod() {
        System.out.println("Default method\n-----------------");
    }
    static void staticMethod(){
        System.out.println("Static method\n-----------------");
    }
    void justMethod();
}
