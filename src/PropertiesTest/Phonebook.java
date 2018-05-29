package PropertiesTest;

//Простая база данных телефонных номеров,
//построенная на основе списков свойств

import java.io.*;
import java.util.Properties;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        Properties ht = new Properties();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name, number;
        FileInputStream fis = null;
        boolean changed = false;

        try {
            fis = new FileInputStream("phonebook.dat");
        } catch (FileNotFoundException e) {/*игнорировать несуществующий файл*/}

        //Если телефонная книга существует - загрузить телефонные номера.
        try {
            if (fis != null) {
                ht.load(fis);
                fis.close();
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла");
        }

        //разрешить пользователю вводить новые имена
        //и номера телефонных абонентов
        do {
            System.out.println("Введите имя ('выход' для завершения): ");
            name = br.readLine();
            if (name.equals("выход")) continue;
            System.out.println("Введите номер");
            number = br.readLine();
            ht.put(name, number);
            changed = true;
        } while (!(name.equals("выход")));

        //Сохранить телефонную книгу, если она изменилась
        if (changed) {
            FileOutputStream fos = new FileOutputStream("phonebook.dat");
            ht.store(fos, "Телефонная книга");
            fos.close();
        }

        //Искать номер по имени абонента
        do {
            System.out.println("Введите имя для поиска ('выход' для завершения): ");
            name = br.readLine();
            if (name.equals("выход")) continue;
            number = (String) ht.get(name);
            System.out.println(number);
        } while (!(name.equals("выход")));
    }
}
