package StreamAPI.StreamAPIShildt;


import java.util.ArrayList;
import java.util.stream.Stream;

public class StreamDemo_5 {
    public static void main(String[] args) {
        //Список номеров, телефонов и адресов эл.почт
        ArrayList<NamePhoneEmail> myList = new ArrayList<>();
        myList.add(new NamePhoneEmail("Ларри", "555-5555", "larry@mail.ru"));
        myList.add(new NamePhoneEmail("Мери", "555-4444", "mery@mail.ru"));
        myList.add(new NamePhoneEmail("Джеймс", "555-3333", "james@mail.ru"));

        System.out.printf("%s:\n", "Исходные элементы списка myList");
        myList.stream().forEach(a -> System.out.printf("%s, %s, %s\n", a.name, a.phoneNum, a.email));

        //Отобразить на новый поток данных
        //только имена и номера телефонов

        Stream<NamePhone> namePhoneStream = myList.stream()
                .map(a -> new NamePhone(a.name, a.phoneNum));
        System.out.println("\nСписок имён и телефонов:");
        namePhoneStream.forEach((a) -> System.out.printf("%s, %s\n", a.name, a.phone));
    }

    static class NamePhoneEmail {
        String name;
        String phoneNum;
        String email;

        NamePhoneEmail(String name, String phoneNum, String email) {
            this.name = name;
            this.phoneNum = phoneNum;
            this.email = email;
        }
    }

    static class NamePhone {
        String name;
        String phone;

        NamePhone(String name, String phone) {
            this.name = name;
            this.phone = phone;
        }
    }
}