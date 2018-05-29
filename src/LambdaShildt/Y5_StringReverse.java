package LambdaShildt;

public class Y5_StringReverse {
    interface Reverse {
        String stringReverse(String s);
    }

    public static void main(String[] args) {
        Reverse reverse = str -> {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.reverse();
            return stringBuilder.toString();
        };
        System.out.println(reverse.stringReverse("Мама мыла раму"));
    }
}
