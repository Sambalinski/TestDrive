package NIO_Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FromInternetToFile {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/testdata/secretPasswords.txt");
        InputStream inputStream = url.openStream();
        Path file = Paths.get("D:/test.tmp");
        Files.copy(inputStream, file, StandardCopyOption.REPLACE_EXISTING);
        inputStream.close();
        Files.move(file, Paths.get("D:/testFiles/result.txt"));
    }
}
