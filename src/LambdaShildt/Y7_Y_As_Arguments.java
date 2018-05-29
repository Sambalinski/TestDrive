package LambdaShildt;

public class Y7_Y_As_Arguments {
    interface StringFunc {
        String func(String s);
    }

    static String strOper(StringFunc sFunc, String s) {
        return sFunc.func(s);
    }

    public static void main(String[] args) {
        //переменные
        String inStr1 = "Лямбда-выражения повышают эффективность Java.";
        String inStr2 = "Это ещё одна строка";
        String outStr1;
        String outStr2;


        System.out.println("Это исходная строка: " + inStr1);


        outStr1 = strOper((s) -> {
            s = s.toLowerCase();
            s = s + " Hello, World!";
            return s;
        }, inStr1);

        System.out.println(outStr1);

        StringFunc strFunc = s -> {
            return s.toUpperCase();
        };

        outStr2 = strOper(strFunc, inStr2);

        System.out.println(outStr2);

        System.out.println(strFunc.func("просто текст"));

    }
}