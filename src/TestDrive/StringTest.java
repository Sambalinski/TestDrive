package TestDrive;

public class StringTest {
    public static void main(String[] args) throws java.lang.Exception {
        String s1 = "abc";
        s1 = append1(s1, "def");

        String s2 = "abc";
        s2 = append2(s2, "def");

        StringBuilder builder = new StringBuilder("abc");
        append(builder, "def");

        System.out.println(s1);
        System.out.println(s2);
        System.out.println(builder.toString());
    }

    static String append1(String in, String append) {
        return in + append;
    }

    static String append2(String in, String append) {
        return new String(in.concat(append));
    }

    static void append(StringBuilder in, String append) {
        in.append(append);
    }

}

