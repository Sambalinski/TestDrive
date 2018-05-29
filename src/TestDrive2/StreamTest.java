package TestDrive2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamTest {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String collect = Files.lines(Paths.get(reader.readLine()))
                    .flatMap(s -> Arrays.stream(s.split(" ")))
                    .filter(s -> isDigit(s))
                    .collect(Collectors.joining(" "));

            System.out.println(collect);

        } catch (Exception e) {
        }
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

