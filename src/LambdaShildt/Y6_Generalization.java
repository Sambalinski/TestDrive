package LambdaShildt;

public class Y6_Generalization {
    interface MyFunc<T> {
        T func(T t);
    }

    public static void main(String[] args) {
        MyFunc<Integer> factorial = n -> {
            int result = 1;
            for (int a = 1; a <= n; a++) {
                result *= a;
            }
            return result;
        };
        System.out.println(factorial.func(5));
        System.out.println(factorial.func(3));


        MyFunc<String> reverse = str -> {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.reverse();
            return stringBuilder.toString();
        };
        System.out.println(reverse.func("Мама мыла раму"));
    }
}

