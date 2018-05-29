package LambdaShildt;

public class Y3_WithTwoParametrs {
    interface NumericTest {
        boolean numTest(int a, int b);
    }

    public static void main(String[] args) {
        NumericTest isFactor = (n, m) -> n % m == 0;

        if (isFactor.numTest(10, 5)) System.out.println("5 является множителем 10");
        if (!isFactor.numTest(10, 7)) System.out.println("7 не является множителем 10");
    }
}
