package ZipTests;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileToZip {
    public static void main(String[] args) throws IOException {
        try(ZipOutputStream zos = new ZipOutputStream(new FileOutputStream("d:/testDir/archive.zip"))) {
            ZipEntry zipEntry = new ZipEntry("document.txt");
            zos.putNextEntry(zipEntry);
        } catch (Exception e) {e.printStackTrace();}
    }
}
