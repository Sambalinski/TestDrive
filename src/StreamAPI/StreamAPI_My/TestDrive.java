package StreamAPI.StreamAPI_My;

import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestDrive {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();

        myList.add(1.1);
        myList.add(3.6);
        myList.add(9.2);
        myList.add(4.7);
        myList.add(12.1);
        myList.add(5.0);

        IntStream intStream = myList.stream().mapToInt(a -> (int) Math.ceil(a));
        intStream.forEach(a -> System.out.print(a + " "));


        ArrayList<String> list = new ArrayList<>();
        list.add("dd2");
        list.add( "aa2");
        list.add("bb1");
        list.add("bb3");
        list.add("cc4");

        Stream<String> stringStream = list.stream()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                });
                stringStream.forEach(s -> System.out.println("forEach: " + s));
    }
}
