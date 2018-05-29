package ZipTests;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipToFile {
    public static void main(String[] args) {
        ByteArrayOutputStream tmpBAOS = new ByteArrayOutputStream();
        byte[] buff = new byte[1024];
        int length;
        Path pathONE = Paths.get("D:\\Ace_Of_Base_Happy_Nation_Wiliam.zip");
        Path pathTWO = Paths.get("D:\\tmpArch-5279909208314600504.zip");

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(pathTWO.toFile()))) {
            ZipEntry ze = zis.getNextEntry();
            System.out.println(ze.getName());
            while ((length = zis.read(buff)) > 0) {
                tmpBAOS.write(buff, 0, length);
            }
        } catch (Exception e) {e.printStackTrace();}

        System.out.println(tmpBAOS.size());

        try (FileOutputStream fos = new FileOutputStream("d:/result.mp3")) {
            fos.write(tmpBAOS.toByteArray());
        } catch (Exception e) {e.printStackTrace();}
    }
}
