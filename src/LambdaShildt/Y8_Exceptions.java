package LambdaShildt;

public class Y8_Exceptions {
    interface DoubleNumericArrayFunction {
        double func(double d[]) throws EmptyArrayException;
    }

    static class EmptyArrayException extends Exception {
        EmptyArrayException () {
            super ("Массив пуст.");
        }
    }

    public static void main(String[] args) throws EmptyArrayException {
        double[] doubles = new double[]{1.6, 3, 4.8, 7.7};

        DoubleNumericArrayFunction dNAF = (double [] d) -> {
            double sum = 0;
            if (d.length == 0) throw new EmptyArrayException();
            for (int i = 0; i < d.length; i++) sum += d[i];
            return sum / d.length;
        };
        System.out.println(dNAF.func(doubles));
        System.out.println(dNAF.func(new double[0]));
    }
}
