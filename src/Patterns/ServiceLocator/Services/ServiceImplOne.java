package Patterns.ServiceLocator.Services;

public class ServiceImplOne implements Service {
    public void execute() {
        System.out.println("Executing Service1");
    }

    @Override
    public String getName() {
        return "Service1";
    }
}
