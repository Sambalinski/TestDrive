package LambdaShildt;

public class Y9_LinksToStaticMethods {
    interface StringFunc {
        String func(String n);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность в Java";
        String outStr;


        outStr = stringOp(Y9_LinksToStaticMethods::strReverse, inStr);
        System.out.println(outStr);
    }

    static String strReverse(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str += (s.charAt(i));
        }
        return str;
    }

    static String stringOp(StringFunc sf, String s) {
        return sf.func(s);
    }
}
