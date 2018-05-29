package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.Optional;

public class StreamDemo_2 {
    public static void main(String[] args) {
        ArrayList<Integer> myList = new ArrayList<>();
        myList.add(7);
        myList.add(18);
        myList.add(10);
        myList.add(24);
        myList.add(17);
        myList.add(5);

    //Два способа получения результата перемножения целочисленных
    //элементов списка myList с помощью метода reduce()
//        Optional<Integer> productObj = myList.stream().reduce((a, b) -> {
//            System.out.printf("\n%s:     %d    %s:     %d\n%s:     %d\n", "Значение а ", a, "Значение b ", b, "Произведение a * b", a*b);
//            return a * b;
//        });
//        if (productObj.isPresent()) System.out.println("\nПроизведение элементов списка в виде обънкта типа Optional: "
//                + productObj.get());

    //способ 2
        int product = myList.stream().reduce(1, (a, b) -> {
            System.out.printf("\n%s:     %d    %s:     %d\n%s:     %d\n", "Значение а ", a, "Значение b ", b, "Произведение a * b", a*b);
            return a*b;
        });
        System.out.println("Произведение элементов списка в виде обънкта типа int: " + product);
    }
}
