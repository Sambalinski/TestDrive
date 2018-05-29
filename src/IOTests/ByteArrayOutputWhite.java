package IOTests;

import java.io.*;

public class ByteArrayOutputWhite {
    public static void main(String[] args) throws IOException {
        String fileName1 = "D:\\f1.txt", fileName2 = "D:\\f2.txt";

        ByteArrayOutputStream array = new ByteArrayOutputStream();
        FileInputStream file1 = new FileInputStream(fileName1);
        FileInputStream file2 = new FileInputStream(fileName2);

        while (file2.available() > 0) array.write(file2.read());
        while (file1.available() > 0) array.write(file1.read());
        file1.close();
        file2.close();

        new FileOutputStream(fileName1).write(array.toByteArray());
    }
}
