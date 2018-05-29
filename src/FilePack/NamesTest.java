package FilePack;

import java.io.File;

public class NamesTest {
    public static void main(String[] args) {
        File file = new File("D:\\Programmes\\utorrent-2.2.1.exe");

        String parentPath = file.getParent();

        file = new File(parentPath);

        String[] list = file.list();

        for (String s : list)
            System.out.println(s);
    }
}
