package TestDrive;


import java.util.HashMap;
import java.util.Map;

public class PasswordValidation {
    public static void main(String[] args) {
        String string = new String("String");
        Map<String, Boolean> mapOfValidation = validation(string);
        for (Map.Entry<String, Boolean> entry : mapOfValidation.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static Map<String, Boolean> validation(String string) {
        //переменные
        int length = 8;
        char[] numbers = "0123456789".toCharArray();
        char[] alphabetBigCase = "ABCDEFGHIGKLMNOPQRSTUVWXYZ".toCharArray();
        char[] alphabetLowerCase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        boolean numbersExists,  alphabetBigCaseExists, alphabetLowerCaseExists, lengthStringOk;
        Map<String, Boolean> mapOfValidation = new HashMap<>();

        //реализация функции проверки
        Contains contains = ((s, charArr) -> {
            boolean exists = false;
            for (int i = 0; i < charArr.length; i++) {
                if (s.contains("" + charArr[i])) return true;
            }
            return exists;
        });

        numbersExists = contains.containsFunc(string, numbers);
        alphabetBigCaseExists = contains.containsFunc(string, alphabetBigCase);
        alphabetLowerCaseExists = contains.containsFunc(string, alphabetLowerCase);
        lengthStringOk = string.length() == length;

//        if (numbersExists && alphabetBigCaseExists && alphabetLowerCaseExists && lengthStringOk) return true;

        mapOfValidation.put("numbersExists", numbersExists);
        mapOfValidation.put("alphabetBigCaseExists", alphabetBigCaseExists);
        mapOfValidation.put("alphabetLowerCaseExists", alphabetLowerCaseExists);
        mapOfValidation.put("lengthStringOk", lengthStringOk);

        return mapOfValidation;
    }

    interface Contains {
        boolean containsFunc (String s, char[] chars);
    }
}