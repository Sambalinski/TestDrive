package InvocationHandlerTest.NoInterfaces;

import java.lang.reflect.Constructor;
import java.lang.reflect.Proxy;

public class MainClass {
    public static void main(String[] args) throws NoSuchMethodException {
        Person personOriginal = new Person("Bonifacii", 23, true);

        ClassLoader classLoader = personOriginal.getClass().getClassLoader();
        Class<?>[] interfaces = personOriginal.getClass().getInterfaces();
        MyInvocationHandler invocationHandler = new MyInvocationHandler(personOriginal);

        Object person = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        ((Person) person).identification(1);
        ((Person) person).sayHello();

    }
}
