package AbstractAndInterface;

public class MyClassImplIntef implements TestInterface {
    public static void main(String[] args) {
        TestInterface testInterface = new MyClassImplIntef();

        //Вызываем статический метод
        TestInterface.staticMethod();

        //Вызываем переопределённый default метод
        testInterface.defaultMethod();

        //Вызываем переопределённый метод
        testInterface.justMethod();

        //Вызываем default метод. Для этого создаём ЭКЗЕМПЛЯР ИНТЕРФЕЙСА
        TestInterface testInterface1 = new TestInterface() {
            @Override
            public void justMethod() {

            }
        };
        testInterface1.defaultMethod();
    }

    @Override
    public void justMethod() {
        System.out.println("Переопределённый метод\n-----------------");
    }

    //Переопределённый default метод
    @Override
    public void defaultMethod() {
        System.out.println("Переопределённый default метод\n-----------------");
    }
}
