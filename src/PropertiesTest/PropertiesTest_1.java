package PropertiesTest;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class PropertiesTest_1 {
    public static void main(String[] args) throws IOException {
        Properties capitals = new Properties();
        capitals.put("Иллинойс", "Спрингфилд");
        capitals.put("Миссури", "Джефферсон-Сити");
        capitals.put("Вашингтон", "Олимпия");
        capitals.put("Калифорния", "Сакраменто");
        capitals.put("Индиана", "Индианаполис");

        //Получить множество ключей
        Set<?> states = capitals.keySet();

        //Показать все штаты и их столицы
        for (Object name : states)
            System.out.println("Столица штата " + name + " - " + capitals.getProperty((String)name) + ".");

        System.out.println();

        //Найти штат, отсутствующий в списке, указав значения,
        //выбираемые по умолчанию

        String str = capitals.getProperty("Флорида", "не найдена");
        System.out.println("Столица штата Флорида " + str + ".");

        Enumeration<?> enumeration = capitals.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = capitals.getProperty(key);
        }
        //Можно добавить списов свойств по умолчаниию.
        //
        //
        //
        //
        //
        //
        Properties defList = new Properties();
        defList.getProperty("Флорида", "Тэлесси");
        defList.getProperty("Висконсин", "Мэдисон");

        Properties capitals2 = new Properties(defList);
        capitals.put("Иллинойс", "Спрингфилд");
        capitals.put("Миссури", "Джефферсон-Сити");
        capitals.put("Вашингтон", "Олимпия");
        capitals.put("Калифорния", "Сакраменто");
        capitals.put("Индиана", "Индианаполис");

    }
}
