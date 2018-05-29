package TestDrive;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/**
 http://info.javarush.ru/L2CCCP/2015/06/07/Генерация-случайного-числа-в-заданном-диапазоне.html
 */
public class RandomTest {
    public static void main(String[] args) {
        int a = 3;
        int b = 10;
        ArrayList<Integer> list = new ArrayList(1000);

        for (int i = 0; i < 1000; i++) {
            int random = a + (int) (Math.random() * b);
            list.add(random);
        }

        AtomicInteger count = new AtomicInteger();
        list.stream()
                .forEach(f -> {
                    if (f == 12){
                        count.getAndIncrement();
                        System.out.println(count + " - " + f);
                    }
                });
    }
}
