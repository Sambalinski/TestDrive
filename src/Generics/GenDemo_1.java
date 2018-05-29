package Generics;

public class GenDemo_1 {
    public static void main(String[] args) {
        GenClass<Integer> iOb;
        iOb = new GenClass<>(80);
        iOb.showType();

        int i = iOb.getob();

        System.out.println("i value: " + i);
    }

    static class GenClass<T> {
        T ob;

        GenClass(T o) {
            ob = o;
        }

        T getob() {
            return ob;
        }

        void showType() {
            System.out.println("Типом Т является: " + ob.getClass().getName());
        }
    }
}

