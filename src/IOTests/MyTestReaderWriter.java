package IOTests;

import java.io.*;

public class MyTestReaderWriter {
    public static void main(String[] args) throws Exception {
        try(InputStream inputStream = new FileInputStream("test3")) {
            System.out.println(inputStream.available()%2==0);
            System.out.println(inputStream.available()/2);
        } catch (Exception e){}
    }
}
