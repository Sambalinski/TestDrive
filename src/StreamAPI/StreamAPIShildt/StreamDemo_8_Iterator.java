package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

public class StreamDemo_8_Iterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Альфа");
        list.add("Бета");
        list.add("Гамма");
        list.add("Дельта");
        list.add("Кси");
        list.add("Омега");

        Stream<String> stringStream = list.stream();

        Iterator<String> iterator = stringStream.iterator();

//        while (iterator.hasNext()) System.out.println(iterator.next());

    // Альтернатива вывода: Вывод всеё коллекции целиком без применения цикла

        iterator.forEachRemaining(n -> System.out.println(n));
    }
}
