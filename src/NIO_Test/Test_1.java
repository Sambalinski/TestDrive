package NIO_Test;

import java.io.IOException;
import java.nio.file.*;

public class Test_1 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("d:/testFiles");

        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path file : directoryStream) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException x) {
            System.err.println(x);
        }
    }
}
