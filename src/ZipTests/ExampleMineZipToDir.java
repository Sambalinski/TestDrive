package ZipTests;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExampleMineZipToDir {
    public static void main(String[] args) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream("d:/testDir/archive.zip"));

        //Выводим имена файлов в архиве
//        ZipEntry zipEntry = zis.getNextEntry();
//        while (zis.available() > 0) {
//            if (!zipEntry.isDirectory())
//            System.out.println(zipEntry.getName());
//            zipEntry = zis.getNextEntry();
//        }

        //Метод 1 (Files.copy(inputStream, path))
//        ZipEntry zipEntry = zis.getNextEntry();
//        String fileName;
//
//        while (zis.available() == 1) {
//            Files.copy(zis, Paths.get("d:/testDir/" + zipEntry.getName()));
//            zipEntry = zis.getNextEntry();
//        }

        //Метод 2 с использованием буфера
//        ZipEntry zipEntry = zis.getNextEntry();
        ZipEntry zipEntry;

        String fileName;
        FileOutputStream fos;
        ByteArrayOutputStream baos;
        byte[] buffer = new byte[1024];
        int length;

        while ((zipEntry = zis.getNextEntry()) != null) {
            fileName = "d:/testDir/" + zipEntry.getName();
            fos = new FileOutputStream(fileName);
            baos = new ByteArrayOutputStream();
            while ((length = zis.read(buffer)) > 0) {
                baos.write(buffer, 0, length);
            }
            fos.write(baos.toByteArray());
        }

//        while ((zipEntry = zis.getNextEntry()) != null) {
//            fileName = "d:/testDir/" + zipEntry.getName();
//            fos = new FileOutputStream(fileName);
//            while ((length = zis.read(buffer)) > 0) {
//                fos.write(buffer, 0, length);
//            }
//        }

        zis.close();

    }
}
