package LambdaShildt;

public class Y1_NoParametrs {
    public static void main(String[] args) {
        MyNum myNum;
        myNum = () -> 123.45;
        System.out.println(myNum.getValue());

        myNum = () -> Math.random() * 100;
        System.out.println("random value: " + myNum.getValue() + "\n" +
                "else random value: " + myNum.getValue());
    }

    interface MyNum {
        double getValue();
    }
}

