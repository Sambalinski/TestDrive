package LambdaShildt;

public class MyTest1 {
    public static void main(String[] args) {
        CalcTest calcTest = new CalcTest();
        calcTest.sum(5.5, 7.7);
    }

    interface Calculator {
        double calculate(double a, double b);
    }

    public static class CalcTest {
        Calculator calculator;

        public void sum(double a1, double b1) {
            calculator = (a, b) -> a + b;
            System.out.println(calculator.calculate(a1, b1));
        }
    }
}
