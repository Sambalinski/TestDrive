package RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest_1_group {
    public static void main(String[] args) {
        // Строка для сканирования, чтобы найти шаблон
        String str = "Крещение Руси произошло в 988 году! Не так ли?";
        String pattern = "(.*)(\\d+)(.*)";

        // Создание Pattern объекта
        Pattern r = Pattern.compile(pattern);

        // Создание matcher объекта
        Matcher m = r.matcher(str);

        //Выводим количество груп шаблона
        System.out.println(m.groupCount());

        if (m.find( )) {
            System.out.println("Найдено значение: " + m.group(0));
            System.out.println("Найдено значение: " + m.group(1));
            System.out.println("Найдено значение: " + m.group(2));
            System.out.println("Найдено значение: " + m.group(3));
        }else {
            System.out.println("НЕ СОВПАДАЕТ");
        }
    }
}
