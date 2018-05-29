package LambdaShildt;

public class Y10_LinksOfExemplar {
    interface StringFunc {
        String func(String n);
    }

    public static void main(String[] args) {
        String inStr = "Лямбда-выражения повышают эффективность в Java";
        String outStr;

        Y10_LinksOfExemplar y10 = new Y10_LinksOfExemplar();
        outStr = stringOp(y10::strReverse, inStr);
        System.out.println(outStr);
    }

    private String strReverse(String s) {
        String str = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            str += (s.charAt(i));
        }
        return str;
    }

    static String stringOp(Y9_LinksToStaticMethods.StringFunc sf, String s) {
        return sf.func(s);
    }
}
