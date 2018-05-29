package ZipTests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ExampleLectureZipTest {
    public static void main(String[] args) throws IOException {
// создаем архив
        FileOutputStream zipFile = new FileOutputStream("d:/archive.zip");
        ZipOutputStream zos = new ZipOutputStream(zipFile);

//кладем в него ZipEntry – «архивный объект»
        zos.putNextEntry(new ZipEntry("document.txt"));
//        zip.write("Мама мыла раму".getBytes());

//создаём и копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        Path tempFile = Paths.get("d:/document-for-archive.txt");
        Files.createFile(tempFile);
        Files.write(tempFile, "Мама мыла Раму".getBytes());

        Files.copy(tempFile, zos);
        Files.delete(tempFile);
// закрываем архив
        zos.close();

    }
}
