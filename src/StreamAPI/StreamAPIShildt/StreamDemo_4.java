package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo_4 {
    public static void main(String[] args) {
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(100.0);
        myList.add(121.0);
        myList.add(144.0);

        Stream<Double> streamSqrt = myList.stream()
                .map((aDouble) -> Math.sqrt(aDouble));
        double d = streamSqrt.reduce(1.0, (a, b) -> a * b);
        System.out.printf("%s: %.1f", "Произведение квадратных корней равно", d);
    }
}