package RegexTest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTask {
    private static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) {
        String str = "Это стоит 1 бакс, а вот это - 12 12.\n" +
                "Переменная имеет имя file1 файл 1.\n" +
                "110 - это число.\n" +
                "5\n" +
                "12 ewq 3 trf 7 апв 123 рп 1 ку20";

        Pattern pattern;
        Matcher matcher;


        for (Map.Entry<Integer, String> pair : map.entrySet()) {
            str = str.replaceAll("\\b"+String.valueOf(pair.getKey())+"\\b", pair.getValue());
        }
        System.out.println(str);

        }
}
