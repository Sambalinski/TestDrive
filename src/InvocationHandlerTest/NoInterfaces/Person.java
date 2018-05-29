package InvocationHandlerTest.NoInterfaces;

public class Person {
    private String name;
    private int age;
    private boolean sex;

    public Person(String name, int age, boolean sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public void identification (int i) {
        System.out.printf("Name is %s.\n%d years old.\nSex is %s\n", getName(), getAge(), isSex() ? "male" : "female");
    }

    public void sayHello() {
        System.out.printf("Hello! My name is %s\n", getName());
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isSex() {
        return sex;
    }

}
