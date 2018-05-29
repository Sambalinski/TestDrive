package IOTests;

import java.io.IOException;

public class GetByteCodePoint {
    public static void main(String[] args) throws IOException {
        byte[] b = ",".getBytes("ascii");
        System.out.println(b[0]); //код символа "," в кодировке ascii
        String s = new String(b, "ascii");
        System.out.println(s.equals(","));

        char[] testChars = new char[] {',','b','c','d','e','f','g',' ','1','2','3','4','5','6','7'};
        String str = new String(testChars);
        byte[] bytes = str.getBytes("ascii");
        for ( int i = 0; i < testChars.length; i++ )
            System.out.println(testChars[i] + ": " + bytes[i] );
        }
}
