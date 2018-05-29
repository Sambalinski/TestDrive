package ZipTests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FolderToZip {

    public static void main(String[] args) throws IOException {
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/archive.zip"));


        zos.putNextEntry(new ZipEntry("testFiles/test1.txt"));
        Files.copy(Paths.get("d:/test1.txt"), zos);

        zos.putNextEntry(new ZipEntry("testFiles/"));

        zos.putNextEntry(new ZipEntry("new/тест2.txt"));
        Files.copy(Paths.get("d:/тест2.txt"), zos);

        zos.putNextEntry(new ZipEntry("new/"));

        zos.putNextEntry(new ZipEntry("test3.txt"));
        Files.copy(Paths.get("d:/test3.txt"), zos);

        zos.close();
    }
}
