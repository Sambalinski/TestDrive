package TestDrive2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SystemSetInMyTest {
    public static void main(String[] args) throws Exception {
        String s = "Мама мыла раму";
        InputStream inputStream = new ByteArrayInputStream(s.getBytes());
        System.setIn(inputStream);
//        method();
    }

//    public static void method() {
//        TestDate.print();
//    }

}
