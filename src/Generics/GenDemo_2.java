package Generics;

public class GenDemo_2 {
    public static void main(String[] args) {
        GenClass<Double> genClass = new GenClass<Double>(new Double[]{1.2, 4.0, 7.7 });
        System.out.println(genClass.ts.length);
        System.out.println(genClass.average());
    }

    static class GenClass<T extends Number> {
        T[] ts;

        GenClass(T[] ts) {
            this.ts = ts;
        }

        public double average() {
            double sum = 0;
            for (int i = 0; i < ts.length; i++) {
                sum += ts[i].doubleValue();
            }
            return sum / ts.length;
        }
    }
}

