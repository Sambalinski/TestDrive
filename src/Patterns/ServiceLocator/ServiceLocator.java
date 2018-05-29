package Patterns.ServiceLocator;

import Patterns.ServiceLocator.Services.Service;

public class ServiceLocator {
    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static Service getService(String jndiName) {

        Service service = cache.getService(jndiName);

        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        Service serviceNew = (Service) context.lookup(jndiName);
        cache.addService(serviceNew);
        return serviceNew;
    }
}
