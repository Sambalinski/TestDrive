package TestDrive2;

public class RegexTest {
    public static void main(String[] args) {
        String s = "name.h@gmail.ru";
        System.out.println(s.matches("([a-zA-Z0-9]{1,}[-_.]{0,1}){1,}[a-zA-Z]{1,}[\\@]{1}([a-zA-Z0-9]{1,}[\\-||\\_||\\.]{0,1}){1,}([a-zA-Z]{1,}[\\.]{1}[a-zA-Z]{1,})"));
    }
}
