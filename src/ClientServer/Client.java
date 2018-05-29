package ClientServer;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static final String UNIC_BINDING_NAME = "server.reverse";

    public static void main(String[] args) throws Exception
    {
        //создание реестра расшареных объетов
        final Registry registry = LocateRegistry.createRegistry(2099);

        //получаем объект (на самом деле это proxy-объект)
        Reverse service = (Reverse) registry.lookup(UNIC_BINDING_NAME);

        //Вызываем удаленный метод
        String result = service.reverse("Home sweet home.");
    }
}
/**
  Строка 7 – уникальное имя удаленного объекта. Должно быть одинаковым на клиенте и сервере.

 Строка 12 – создание объекта «Реестр удаленных объектов». Его порт 2099 должен быть таким же,
 как и у реестра у серверного приложения.

 Строка 15 – получаем объект у реестра. Полученный объект является proxy-объектом и приводится к типу интерфейса.
 Интерфейс должен быть унаследован от интерфейса-маркера Remote.

 Строка 18 – вызываем методы интерфейса так, как будто объект был создан в этой же программе.
 */