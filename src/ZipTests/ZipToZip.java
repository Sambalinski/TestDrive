package ZipTests;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipToZip {
//    public static HashMap<String, ByteArrayOutputStream> map = new HashMap<>(); //временное хранилище
//
//    public static void readArchive() {
//
//    }

    public static void main(String[] args) throws IOException {
        HashMap<String, ByteArrayOutputStream> map = new HashMap<>(); //временное хранилище
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream("d:/archive.zip"))) { //поток чтения из архива

            ZipEntry zipEntry;

            ByteArrayOutputStream baos;
            byte[] buffer = new byte[1024];
            int length;

            //Рабочий вариант
//        while ((zipEntry = zis.getNextEntry()) != null) {
//            if (!(zipEntry.isDirectory())) {
//                baos = new ByteArrayOutputStream();
//                while ((length = zis.read(buffer)) > 0) {
//                    baos.write(buffer, 0, length);
//                }
//                map.put(zipEntry.getName(), baos); //записываем во временное хранилище
//            }
//        }

            //Экпериментируем
            while ((zipEntry = zis.getNextEntry()) != null) {
                baos = new ByteArrayOutputStream();
                while ((length = zis.read(buffer)) > 0) {
                    baos.write(buffer, 0, length);
                }
                System.out.println(zipEntry.getName());
                System.out.println(baos.size());
                map.put(zipEntry.getName(), baos); //записываем во временное хранилище
            }
        }
        System.out.println("***");

        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/archiveResult.zip"))) { //поток для записи в новый архив

            for (Map.Entry<String, ByteArrayOutputStream> m : map.entrySet()) { //записываем в новый архив
                System.out.print(m.getKey() + "\t"); //имя
                System.out.println(m.getValue().size()); //размер
                zos.putNextEntry(new ZipEntry(m.getKey()));
                zos.write(m.getValue().toByteArray());
            }
        }
    }
}
