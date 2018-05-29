package ZipTests;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ExampleUnZip {

    private static final String ZIP_ARCHIVE = "D:/testDir/archive.zip";

    private static final int BUFFER_SIZE = 1024;

    public static void main(String[] args) {
        ExampleUnZip app = new ExampleUnZip();
        app.unZip(ZIP_ARCHIVE);
    }

    private void unZip(final String zipFileName) {
        byte[] buffer = new byte[BUFFER_SIZE];

        // Создаем каталог, куда будут распакованы файлы
        final String dstDirectory = destinationDirectory(zipFileName);
        final File dstDir = new File(dstDirectory);
        if (!dstDir.exists()) {
            dstDir.mkdir();
        }

        try {
            // Получаем содержимое ZIP архива
            final ZipInputStream zis = new ZipInputStream(
                    new FileInputStream(zipFileName));
            ZipEntry ze = zis.getNextEntry();
            String nextFileName;
            while (ze != null) {
                nextFileName = ze.getName();
                File nextFile = new File(dstDirectory + File.separator
                        + nextFileName);
                System.out.println("Распаковываем: "
                        + nextFile.getAbsolutePath());
                // Если мы имеем дело с каталогом - надо его создать. Если
                // этого не сделать, то не будут созданы пустые каталоги
                // архива
                if (ze.isDirectory()) {
                    nextFile.mkdir();
                } else {
                    // Создаем все родительские каталоги
                    new File(nextFile.getParent()).mkdirs();
                    // Записываем содержимое файла
                    try (FileOutputStream fos
                                 = new FileOutputStream(nextFile)) {
                        int length;
                        while ((length = zis.read(buffer)) > 0) {
                            fos.write(buffer, 0, length);
                        }
                    }
                }
                ze = zis.getNextEntry();
            }
            zis.closeEntry();
            zis.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExampleUnZip.class.getName())
                    .log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExampleUnZip.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    private String destinationDirectory(final String srcZip) {
        return srcZip.substring(0, srcZip.lastIndexOf("."));
    }
}

