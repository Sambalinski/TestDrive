package TestDrive2;

public class New_Year {
    private static int count = 0;
    private static int beer = 32;
    private static int champagne = 16;
    private static double caviar = 3.2d;

    public static void main(String[] args) {
        while (true) {
            if (beer == 0 && champagne == 0 && caviar == 0) {
                buy();
            }
            drink(beer, champagne, caviar);
        }
    }

    public static void drink(int beer, int champagne, double caviar) {
        New_Year.beer = -beer;
        New_Year.champagne = -champagne;
        New_Year.caviar = -caviar;
        New_Year.count ++;
        if (New_Year.count % 2 == 0) {
            System.out.println("C Новым Годом! Счастья, здоровья, бла бла бла... Будем!");
        } else System.out.printf("После " + New_Year.count + " не закусывают! ");
    }

    public static void buy() {
        New_Year.beer = +10;
        New_Year.champagne = +7;
        New_Year.caviar = +1.5d;
    }
}
