package RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest_2_start_end {
    public static void main(String[] args) {
//        String regex1 = "\\b1\\b";
//        String input1 = "7r 7 hg7 а7п 7e8q8";

        String str = "Это стоит 1 бакс, а вот это - 12 12.\n" +
                "Переменная имеет имя file1 файл 1.\n" +
                "110 - это число.\n" +
                "5\n" +
                "12 ewq 3 trf 7 апв 123 рп 1 ку20";

//        String regex2 = "\\b\\d";


//        System.out.println(str + "\n");
//        Pattern p = Pattern.compile(regex1);
//        Matcher m = p.matcher(str);   // получение matcher объекта
//        int count = 0;

//        while (m.find()) {
//            count++;
//            System.out.println("Номер вхождения: " + count);
//            System.out.println("Начальная позиция вхождения: " + m.start());
//            System.out.println("Конечная позиция вхождения: " + m.end() + "\n");
//        }

        System.out.println(str.replaceAll("\\b12\\b", "двенадцать"));

//        while (m.find()) {
//            System.out.println(str.substring(m.start(), m.end()));
//        }
    }
}
