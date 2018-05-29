package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.Spliterator;
import java.util.stream.Stream;

public class StreamDemo_10_Spliterator_trySplit {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Альфа");
        list.add("Бета");
        list.add("Гамма");
        list.add("Дельта");
        list.add("Кси");
        list.add("Омега");
        list.add("Эпсилон");

        Stream<String> stringStream = list.stream();

    //Эта половина выводится второй(плюс один нечётный элемент):
        Spliterator<String> stringSpliterator = stringStream.spliterator();

    //Эта половина выводится первой (меньшая часть при нечётном количестве элементов)
        Spliterator<String> stringSpliterator1 = stringSpliterator.trySplit(); //Эта половина выводится первой

        stringSpliterator.forEachRemaining(n -> System.out.println(n));
        System.out.println();
        stringSpliterator1.forEachRemaining(n -> System.out.println(n));
    }
}
