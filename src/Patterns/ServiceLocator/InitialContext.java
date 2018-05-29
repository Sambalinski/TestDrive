package Patterns.ServiceLocator;

import Patterns.ServiceLocator.Services.ServiceImplOne;
import Patterns.ServiceLocator.Services.ServiceImplTwo;

public class InitialContext {
    public Object lookup(String jndiName) {

        if (jndiName.equalsIgnoreCase("SERVICE1")) {
            System.out.println("Looking up and creating a new Service1 object");
            return new ServiceImplOne();
        } else if (jndiName.equalsIgnoreCase("SERVICE2")) {
            System.out.println("Looking up and creating a new Service2 object");
            return new ServiceImplTwo();
        }
        return null;
    }
}
