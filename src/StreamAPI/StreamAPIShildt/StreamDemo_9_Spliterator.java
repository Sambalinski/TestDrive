package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo_9_Spliterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Альфа");
        list.add("Бета");
        list.add("Гамма");
        list.add("Дельта");
        list.add("Кси");
        list.add("Омега");

        Stream<String> stringStream = list.stream();

        Spliterator<String> stringSpliterator = stringStream.spliterator();

        // в tryAdvance объединяются функции hasNext и next аналогично
        // обычному Iterator
        while (stringSpliterator.tryAdvance(n -> System.out.println(n))) ;

        //Так же можно применить метод forEachRemaining
//        stringSpliterator.forEachRemaining(n-> System.out.println(n));
    }
}
