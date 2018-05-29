package TestDrive2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        String str1 = "Иванов Иван Иванович 31 12 1987";
        String str2 = "Вася 05 5 2013";

        String date = str2.replaceAll("[А-яA-z]", "").trim();

        //Парсим и форматируем дату при помощи SimpleDateFormat
        Date realDate = new SimpleDateFormat("dd mm yyyy").parse(date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd mm yyyy");
        System.out.println();

        //Сразу присваиваем дату в конструкторе
        Date realDate2 = new Date(1987-1900, 12-1, 31);
        System.out.println("\n" + realDate);

        System.out.println("\n" + str1.replaceAll("[А-яaA-z]", "").trim() + "\n"
        + str2.replaceAll("[А-яaA-z]", "").trim());
    }
}
