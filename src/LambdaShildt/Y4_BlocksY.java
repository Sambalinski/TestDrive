package LambdaShildt;

public class Y4_BlocksY {
    interface NumericFunc {
        int func (int i);
    }

    public static void main(String[] args) {

        NumericFunc factorial = n -> {
            int result = 1;
            for (int a = 1; a <= n; a ++) {
                result *= a;
            }
            return result;
        };
        System.out.println(factorial.func(5));
        System.out.println(factorial.func(3));
    }
}
