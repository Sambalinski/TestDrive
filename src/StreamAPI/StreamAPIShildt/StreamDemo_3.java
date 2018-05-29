package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;

public class StreamDemo_3 {
    public static void main(String[] args) {

    // Теперь это список числовых значений типа double
        ArrayList<Double> myList = new ArrayList<>();
        myList.add(100.0);
        myList.add(121.0);
        myList.add(144.0);

        double productOfSqrRoots = myList.parallelStream().unordered().reduce(1.0,
                (a, b) -> {
                    System.out.println("\nНакопитель:\n" + "Значение a:  " + a + "     Значение b:   " +  b
                            + "\nКорнень из " + b + ":  " + Math.sqrt(b) + "\nПроизведение a * Math.sqrt(b):    " + a * Math.sqrt(b));
           return a * Math.sqrt(b);},

                (a, b) -> {
                    System.out.printf("\nОбъединитель:\n%s:     %.1f    %s:     %.1f\n%s:     %.1f\n", "Значение а ", a, "Значение b ", b, "Произведение a * b", a*b);
            return a * b;});

        System.out.println("\nПроизведение квадратных корней:   " + productOfSqrRoots);

//        double productOfSqrRoots2 = myList.stream().unordered().reduce(1.0, (a, b) -> {
//            System.out.println("\nНакопитель:\n" + "Значение a:  " + a + "     Значение b:   " +  b
//                    + "\nКорнень из " + b + ":  " + Math.sqrt(b) + "\nПроизведение a * Math.sqrt(b):    " + a * Math.sqrt(b));
//            return a * Math.sqrt(b);
//        });
//
//        System.out.println("\nПроизведение квадратных корней:   " + productOfSqrRoots2);


        /*
        Накопитель:
        Значение a:     1.0     Значение b:  121.0
        Корнень из 121.0:   11.0
        Произведение a * Math.sqrt(b):  11.0

        Накопитель:
        Значение a:     1.0     Значение b:  144.0
        Корнень из 144.0:   12.0
        Произведение a * Math.sqrt(b):  12.0

        Объединитель:
        Значение а:     11,0    Значение b:    12,0
        Произведение a * b     132,0

        Накопитель:
        Значение a:     1.0     Значение b:    100.0
        Корнень из 100.0:   10.0
        Произведение a * Math.sqrt(b):  10.0

        Объединитель:
        Значение а:    10,0    Значение b:      132,0
        Произведение a * b:     1320,0

        Произведение квадратных корней: 1320.0
        */
    }
}
