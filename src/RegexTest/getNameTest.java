package RegexTest;

public class getNameTest {
    public static void main(String[] args) {
        String url1 = "https://javarush.ru/testdata/secretPasswords.txt";
        String url2 = "http://toogle.com/files/rules.txt";
        String url3 = "https://pacemook.com/photos/image1.jpg";

        String name = url1.replaceAll(".+/", "");
        System.out.println(name);
    }
}
