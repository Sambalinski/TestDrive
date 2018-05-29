package TestDrive2;

public class TestImplInterf implements InterfaceTest {
    //Переопределение метода работает для расширенного до класса экземпляра
    @Override
    public void strDefault() {
        System.out.println("Override lol default");
    }

    public static void main(String[] args) {
        InterfaceTest interfaceTest = new InterfaceTest() {
            //Если нужно переопределить метод для не расширенного до текущего класса
            //экземпляра интерфейса, то нужно переопределять его здесь.
        };
        //Выводим методы интерфейса
        interfaceTest.strDefault();
        InterfaceTest.str1Static();

        InterfaceTest testImplInterf = new TestImplInterf();
        testImplInterf.strDefault();

    }
}
