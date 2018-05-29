package LambdaShildt;

public class Y2_WithOneParametr {
    public static void main(String[] args) {
        NumericTest isEven;
        isEven = (n) -> (n % 2) == 0;

        if (isEven.test(8)) System.out.println("Число 8 чётное");
        else System.out.println("lol");

        isEven = n -> n > 0;
        System.out.println("Число 1 положительное: " + isEven.test(1));
    }
    interface NumericTest {
        boolean test(int i);
    }
}
