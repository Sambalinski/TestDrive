package InvocationHandlerTest.WithInterfaces;

import java.lang.reflect.Proxy;

public class MainClass {
    public static void main(String[] args) {
        Person personOriginal = new Person("Bonifacii", 23, true);

        ClassLoader classLoader = personOriginal.getClass().getClassLoader();
        Class<?>[] interfaces = personOriginal.getClass().getInterfaces();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(personOriginal);

        Object person = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        ((IdentificationPerson) person).identification(1);
        ((GreetingPerson) (person)).sayHello();









//        //Интерфейс IdentificationPerson
//        IdentificationPerson person1 = (IdentificationPerson) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
//        person1.identification(1);
//
//        System.out.println();
//
//        //Интерфейс GreetingPerson
//        GreetingPerson person2 = (GreetingPerson) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
//        person2.sayHello();

    }
}
