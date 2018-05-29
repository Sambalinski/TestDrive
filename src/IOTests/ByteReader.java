package IOTests;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;


/*http://info.javarush.ru/Joysi/2016/02/18/Побайтовая-работа-с-файлами.html*/
public class ByteReader {
    // С Буфером
    public static void main(String[] args) throws Exception {

        FileInputStream inputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
        long[] arrBytes = new long[256];
        long startTime = System.currentTimeMillis();

        int bufferSize = 64000;
        byte buffer[] = new byte[64000];

        while (inputStream.available() > 0) {
            if (inputStream.available() < 64000) bufferSize = inputStream.available();
            inputStream.read(buffer, 0, bufferSize);
            for (int i = 0; i < bufferSize; i++) arrBytes[buffer[i] & 0b11111111]++;
        }

        inputStream.close();
        // Выводим отсортированный по байт-коду в обратном порядке
        for (long i = 255; i >= 0; i--)
            if (arrBytes[(int) i] > 0) System.out.print(i + " ");

        long finishTime = System.currentTimeMillis();
        System.out.println("\nвремя работы=" + (finishTime - startTime) + "ms.");
    }
//      Без буфера
//    public static void main(String[] args) throws Exception {
//        int[] arrBytes = new int[256];
//        try (InputStream inputStream = new FileInputStream(new Scanner(System.in).nextLine())) {
//            while (inputStream.available() > 0) arrBytes[inputStream.read()]++;
//        } catch (Exception e) {
//        }
//        int maxCount = 0;
//        for (int i = 0; i <= 255; i++)
//            for (int j = 0; j <= 255; j++) {
//            if (maxCount < arrBytes[i]) maxCount = arrBytes[i];
//            }
//        for (int i = 0; i <= 255; i++)
//            if (arrBytes[i] == maxCount) System.out.print(i + " ");
//    }
}
