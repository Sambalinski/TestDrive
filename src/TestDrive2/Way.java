package TestDrive2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Way {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        for (String s = reader.readLine(); !"end".equals(s); s = reader.readLine()) list.add(s);
        Collections.sort(list);
        FileOutputStream fileOutputStream = new FileOutputStream(list.get(0).replaceAll("(\\.part\\d+)$", ""));
        FileInputStream inputStream;
        for (String s : list) {
            inputStream = new FileInputStream(s);
            fileOutputStream.write(inputStream.read(new byte[inputStream.available()]));
            inputStream.close();
        }
        fileOutputStream.close();
    }
}
