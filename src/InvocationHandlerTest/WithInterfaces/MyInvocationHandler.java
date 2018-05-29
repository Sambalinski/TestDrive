package InvocationHandlerTest.WithInterfaces;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler{
    private Person person;

    public MyInvocationHandler(Person person) {
        this.person = person;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Переопределено:");
        return method.invoke(person, args);
    }
}
