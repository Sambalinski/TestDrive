package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamDemo_6 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);

        System.out.print("Исх. значения списка: ");
        myList.stream().forEach(a -> System.out.print(a + " "));

        //Отобразить максимально допустимый предел каждого
        //значения из списка myList на поток данных типа IntStream

        IntStream intStream = myList.stream().mapToInt(a ->(int) Math.ceil(a));

        System.out.print("\nМаксимально допустимые пределы значений из списка: ");

        intStream.forEach(a-> System.out.print(a + " "));

    //Тут можно выводить через forEach в конвйере
        DoubleStream.of(1.1, 3.6)
                .mapToInt(a -> (int) Math.ceil(a))
                .forEach(a->System.out.print(a + " ")); //тут

    }
}
