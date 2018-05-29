package NIO_Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;

public class SizeOfDirectory {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("D:/testFiles/jdk-8u162-windows-x64.exe");
        long size = Files.size(path);

        System.out.println(size);
    }
}
