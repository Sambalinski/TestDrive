package ZipTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipInputStream;

public class SplitZip {

    public void createZip() {

    }

    public static void main(String[] args) {
        Path file = Paths.get("D:\\testDir\\Ace_Of_Base_Happy_Nation_Wiliam.mp3");

        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(file.toFile()))) {

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
