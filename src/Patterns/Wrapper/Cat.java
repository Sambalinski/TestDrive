package Patterns.Wrapper;

public class Cat {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printSomth(){
        System.out.println("Что-то мяукает");
    }
}
