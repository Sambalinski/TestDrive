package IOTests;

import java.io.*;
import java.net.URL;

public class TestInputOutput {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.google.com");
        InputStream inet = url.openStream();
//        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        OutputStream outFile = new FileOutputStream("d:/tmp/google.html");
        copy(inet, outFile);

//        byte[] rawData = buff.toByteArray();
//        String html = new String(rawData, "ascii");
//        System.out.println(html);
    }

    public static void copy(InputStream src, OutputStream dst) throws IOException {
        while (true) {
            int elem = src.read();
            if (elem != -1) dst.write(elem);
            else break;
        }
//        while (true) {
//            int elem = src.read();
//            if (elem != -1) dst.write(elem);
//            else break;
//        }
    }
}