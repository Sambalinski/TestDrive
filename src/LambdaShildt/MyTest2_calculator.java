package LambdaShildt;

public class MyTest2_calculator {
    interface CalcFunc {
        double calcFunc(double a, double b);
    }

    static double calculate(double a, double b, CalcFunc calcFunc) {
        return calcFunc.calcFunc(a, b);
    }

    public static void main(String[] args) {
        double result = calculate(5.5, 7.7, (a, b) -> a + b);
        System.out.println(result);
    }
}