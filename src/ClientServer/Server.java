package ClientServer;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception
    {
        //создание объекта для удаленного доступа
        final ReverseImpl service = new ReverseImpl();

        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.createRegistry(2099);
        //создание "заглушки" – приемника удаленных вызовов
        Remote stub = UnicastRemoteObject.exportObject(service, 0);
        //регистрация "заглушки" в реесте
        registry.bind(UNIC_BINDING_NAME, stub);

        //усыпляем главный поток, иначе программа завершится
        Thread.sleep(Integer.MAX_VALUE);
    }
}

/**Строка 9 – в переменной UNIC_BINDING_NAME храним придуманное нами уникальное имя
  нашего удаленного объекта (объекта, который доступен удаленно). Если программа шарит несколько объектов,
  у каждого должно быть свое уникальное имя. Уникальное имя нашего объекта — «server.reverse».

 Строка 14 – собственно, создаем объект ReverseImpl, который будет доступен удаленно, и чьи методы будут вызваться.

 Строка 17 — создаем специальный объект – реестр. В нем надо регистрировать объекты, которые мы шарим.
 Дальше ими занимается Java-машина. 2099 – это порт (уникальный номер, по которому другая программа может
 обратиться к нашему реестру объектов).

 Т.е. чтобы обратиться к объекту, надо знать уникальный номер реестра объектов (порт),
 знать уникальное имя объекта и иметь такой же интерфейс, как и тот, который реализовывает удаленный объект.

 Строка 19 – создание «заглушки». Заглушка – это специальный объект, который принимает информацию
 об удаленном вызове, распаковывает ее, десериализует переданные параметры методов и вызывает нужный метод.
 Затем сериализует результат или исключение, если оно было, и отсылает все это назад вызывающему.

 Строка 21 – регистрируем в реестре заглушку нашего объекта под уникальным именем.

 Строка 24 – усыпляем главный поток. Все удалённые вызовы обрабатываются в отдельных нитях.
 Главное, чтобы программа в это время работала. Так что тут просто отправляем главную нить спать, и всё.
 */