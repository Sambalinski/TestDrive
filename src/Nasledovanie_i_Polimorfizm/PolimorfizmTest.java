package Nasledovanie_i_Polimorfizm;

public class PolimorfizmTest {

    public static void main(String[] s) {
        // Создаем 3 экземпляра дочернего класса С
        A a = new C();
        B b = new C();
        C c = new C();

        System.out.println("При модификаторе private родительского класса -\n" +
                "его методы не переопределяются\n" +
                "\n(method1 класса А с модификатором private):\n");
        a.method1();
        b.method1();
        c.method1();

        System.out.println("");

        a.method2();
        b.method2();
        c.method2();
    }

    //класс А
    public static class A {
        private void method1() {
            System.out.println("A class, method1");
        }

        public void method2() {
            System.out.println("A class, method2");
            method1();
        }
    }

    //класс В
    public static class B extends A {
        public void method1() {
            System.out.println("B class, method1");
        }

        public void method2() {
            System.out.println("B class, method2");
        }
    }

    //класс С
    public static class C extends B {
        public void method1() {
            System.out.println("C class, method1");
        }

        public void method2() {
            System.out.println("C class, method2");
        }
    }
}
