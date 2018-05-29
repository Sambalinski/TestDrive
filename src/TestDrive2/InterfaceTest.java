package TestDrive2;

public interface InterfaceTest {
    default void strDefault(){
         System.out.println("lol default");
    }
    static void str1Static(){
        System.out.println("lol static");
    }
}
