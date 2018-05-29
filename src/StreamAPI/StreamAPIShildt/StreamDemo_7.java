package StreamAPI.StreamAPIShildt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo_7 {
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

        //вызвать метод collect() для сотавления списка типа List
        //из имён и номеров телефоов

        List<NamePhone> namePhoneList = namePhoneStream.collect(Collectors.toList());
        System.out.println("\nИмён и телефоны списка List: ");
        for (NamePhone namePhone : namePhoneList) System.out.println(namePhone.name + " " + namePhone.phone);

        //Аналогично можно получить множество типа  Set


///////W\\\\\\\ ! ! ! ! !    Аналогичный способ получить коллекцию   ! ! ! ! ! ! ///////W\\\\\\\
        //создаём новый поток

        Stream<NamePhone> namePhoneStream1 = myList.stream().map(a -> new NamePhone(a.name, a.phoneNum));
        LinkedList<NamePhone> namePhones = namePhoneStream1.collect(
                () -> new LinkedList<>(),
                (list, element) -> list.add(element),
                (listA, listB) -> listA.addAll(listB));

        System.out.println("\nНовый список ():");
        for (NamePhone namePhone : namePhones) System.out.println(namePhone.name + " " + namePhone.phone);


///////W\\\\\\\ ! ! ! ! !    Ещё один аналогичный способ получить коллекцию   ! ! ! ! ! ! ///////W\\\\\\\
    Stream<NamePhone> namePhoneStream2 = myList.stream().map(a -> new NamePhone(a.name, a.phoneNum));

    LinkedList<NamePhone> namePhones1 = namePhoneStream2.collect(
            LinkedList::new,
            LinkedList::add,
            LinkedList::addAll);

        System.out.println("\nНовый список ():");
        for(
    NamePhone namePhone :namePhones1)System.out.println(namePhone.name +" "+namePhone.phone);

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
